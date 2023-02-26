package com.poc.ai.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author IMRAN
 *
 */
public class CSVParser {

	public void parse(String inputFile, String ouputFilePattern, String header) throws IOException {

		CSVWriter csvWriter = new CSVWriter();
		List<String> list = new ArrayList<>();
		list.add(header);

		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			String line;
			int rowCount = 0;
			int fileCount = 1;

			while ((line = br.readLine()) != null) {

				list.add(line);
				rowCount++;

				if (rowCount % 1001 == 0) {
					// Write chunk
					fileCount = writeChunkFile(ouputFilePattern, header, csvWriter, list, fileCount);
				}
			}
			// Write final chunk
			if (list.size() > 1)
				writeChunkFile(ouputFilePattern, header, csvWriter, list, fileCount);
		}
	}

	private int writeChunkFile(String ouputFilePattern, String header, CSVWriter csvWriter, List<String> list, int fileCount)
			throws IOException {
		csvWriter.writer(list, String.format(ouputFilePattern, fileCount));
		fileCount++;
		list.clear();
		list.add(header);
		return fileCount;
	}
}
