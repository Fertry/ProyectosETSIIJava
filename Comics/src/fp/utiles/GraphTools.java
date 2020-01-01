package fp.utiles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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
	
	public static void sankeyChart(String fileOut, Map<String, List<String>> values) {
		String result = FileTools.text("res/SankeyChartPattern.html");
		String dataText = values.entrySet()
				                .stream()
				                .map(entrada -> filasSankeyChart(entrada.getKey(), entrada.getValue()))
				                .collect(Collectors.joining(",\n","","\n"));
		Map<String,String> rules = new HashMap<>();
		rules.put("data",dataText);
		result = transform(result,rules);
		FileTools.write(fileOut,result);
	}

	private static String filasSankeyChart(String labelKey, List<String> labelValues) {
		Map<String, Long> counts = labelValues.stream()
				                                 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		return counts.entrySet()
				     .stream()
				     .map(entrada -> String.format("['%s','%s', %d]" , labelKey, entrada.getKey(), entrada.getValue()))
				     .collect(Collectors.joining(",\n","","\n"));
	}
}
