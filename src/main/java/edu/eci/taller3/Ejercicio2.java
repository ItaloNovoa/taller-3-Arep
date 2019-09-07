package edu.eci.taller3;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) throws Exception {
		
		//-----------------si desea ingresar la url -----------------------
		/**
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese una Url:");
		String a = scan.nextLine();
		scan.close();
		URL url = new URL(a);*/
		URL url = new URL("https://www.google.es/");

		FileWriter fichero = null;
		PrintWriter pw = null;
		System.out.println();

		try {
			String dir = new File(".").getAbsolutePath();

			// ingrese ubicación de destino del html 
			fichero = new FileWriter(dir + "resultado.html");
			pw = new PrintWriter(fichero);
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
				String inputLine = null;
				while ((inputLine = reader.readLine()) != null) {
					pw.println(inputLine);
				}
			} catch (IOException x) {
				System.err.println(x);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}