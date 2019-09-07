package edu.eci.taller3;

import java.net.*;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.*;

public class Ejercicio4_5_1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(35000);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 35000.");
			System.exit(1);
		}

		while (true) {
			Socket clientSocket = null;
			try {
				System.out.println("Listo para recibir ...");
				clientSocket = serverSocket.accept();
			} catch (IOException e) {
				System.err.println("Accept failed.");
				System.exit(1);
			}
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String inputLine;
			int j = 1;
			String get = "";
			while ((inputLine = in.readLine()) != null) {
				if (j == 1) {
					get = inputLine.substring(5, (inputLine.length() - " HTTP/1.1".length()));
					j++;
				}
				System.out.println("Received: " + inputLine);
				if (!in.ready()) {
					break;
				}
			}

			String url = System.getProperty("user.dir") + "\\" + get;
			System.out.println(url);
			try {
				if (get.contains(".html")) {
					BufferedReader readerFile = new BufferedReader(
							new InputStreamReader(new FileInputStream(url), "UTF8"));
					out.println("HTTP/2.0 200 OK");
					out.println("Content-Type: text/html");
					out.println("\r\n");
					while (readerFile.ready()) {
						out.println(readerFile.readLine());
					}
					readerFile.close();
				}
				else if (get.contains(".png")){
					BufferedImage imagen = ImageIO .read(new File(url));
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(imagen, "png", baos);
                        byte[] imageBy = baos.toByteArray();
                        DataOutputStream outImg = new DataOutputStream(clientSocket.getOutputStream());
                        outImg.writeBytes("HTTP/1.1 200 OK \r\n");
                        outImg.writeBytes("Content-Type: image/png\r\n");
                        outImg.writeBytes("Content-Length: " + imageBy.length);
                        outImg.writeBytes("\r\n\r\n");
                        outImg.write(imageBy);
                        outImg.close();
                        out.println(outImg.toString());
				}

			} catch (FileNotFoundException e) {
				out.println("<!DOCTYPE html>" + "<html>" + "<head>" + "<meta charset=\"UTF-8\">"
						+ "<title>Title of the document</title>\n" + "</head>" + "<body>" + "File Not Found" + "</body>"
						+ "</html>");
			}
			out.close();
			in.close();
			clientSocket.close();
		}
	}
}
