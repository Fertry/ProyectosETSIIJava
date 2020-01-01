package fp.utiles;

import java.util.Locale;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GraphTools {
		
	public static String transform(String in, Map<String,String> reglas) {
		String out = in;
		Pattern pattern;
		for(String p:reglas.keySet()) {
			pattern = Pattern.compile("\\{"+p+"\\}");
			out = pattern.matcher(out).replaceAll(reglas.get(p));
		}
		return out;
	}
	
	public static void barChart(String fileOut, List<String> rowNames, String column1Name,
			Map<String, Double> column1Values, String column2Name, Map<String, Double> column2Values) {
		
		String result = FileTools.text("res/BarChartPattern.html");
		String dataText = rowsBarChart(rowNames, column1Values, column2Values);
		Map<String,String> rules = new HashMap<>();
		rules.put("data",dataText);
		rules.put("header", "['', '"+column1Name+"', '"+column2Name+"']");
		result = transform(result,rules);
		FileTools.write(fileOut,result);
		
	}

	private static String rowsBarChart(List<String> rowNames, Map<String, Double> column1Values, Map<String, Double> column2Values) {
		return rowNames
			     .stream()
			     .map(row -> String.format(Locale.ROOT, "['%s',%.2f, %.2f]" , row, column1Values.get(row), column2Values.get(row)))
			     .collect(Collectors.joining(",\n","","\n"));
	}



}
