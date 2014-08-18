package org.daniels.examples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class QuizMain {

	public static void main(String[] args) throws FileNotFoundException {
		new QuizMain().test();
	}

	public void test() throws FileNotFoundException {
		readSampleFile();
		saveSampleFile();
	}

	public void saveSampleFile() {
		URL url = getClass().getResource("");
		//System.out.println(url);
		try {

			String content = "This is the content to write into file";

			File file = new File("result.txt");

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out
					.println(">>>> Saved file to: " + file.getAbsolutePath());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readSampleFile() throws FileNotFoundException {
//		URL url = getClass().getResource("sample.in");
//		if (url.getPath() != null) {
//			System.out.println(url.getPath());
//		}

		File file = new File("sample.in");
		System.out.println(">>>> Read file from: " + file.getAbsolutePath());
		
		try (final BufferedReader br = new BufferedReader(new FileReader(file))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
