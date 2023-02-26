package com.poc.ai.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author IMRAN
 *
 */
public class CSVWriter {

	public void writer(List<String> list, String outputFile) throws IOException {

		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(outputFile)))) {

			for (String line : list)
				bufferedWriter.write(line + "\n");

		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
