package fp.albumes.test;

import java.lang.Exception;
import java.lang.String;
import java.lang.System;

import fp.albumes.Album;

public class TestAlbum {
	public static void main(String[] args) {
		System.out.println("\nTEST del Constructor");
		try {
			Album obj=new Album(1,1967,"Sgt. Pepper's Lonely Hearts Club Band","The Beatles","Rock");
			System.out.println(obj);
		} catch (Exception e) {
			System.out.println("\nExcepción capturada");
		}
		System.out.println("\nTEST con fallo del Constructor: posición puesta a 0");

		try {
			Album obj=new Album(0,1967,"Sgt. Pepper's Lonely Hearts Club Band","The Beatles","Rock");
			System.out.println(obj);
		} catch (Exception e) {
			System.out.println("\nExcepción capturada");
		}
		System.out.println("\nTEST con fallo del Constructor: año puesto a -1");

		try {
			Album obj=new Album(1,-1,"Sgt. Pepper's Lonely Hearts Club Band","The Beatles","Rock");
			System.out.println(obj);
		} catch (Exception e) {
			System.out.println("\nExcepción capturada");
		}
	}
}
