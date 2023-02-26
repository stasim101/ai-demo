package com.poc.ai.parser;

import java.io.IOException;

/**
 * @author IMRAN
 *
 */
public class CSVProcessor {

	public static void main(String[] args) {

		String header = "PRODUCT_NAME,PRODUCT_PRICE,RATE,REVIEW,SUMMARY,SENTIMENT";
		String outputPath = "C:\\Users\\IMRAN\\Downloads\\archive\\chunks\\chunk-%s.csv";
		String inputFile = "C:\\Users\\IMRAN\\Downloads\\archive\\Dataset-SA_01.csv";
		CSVParser csvParser = new CSVParser();

		try {
			csvParser.parse(inputFile, outputPath, header);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
