/**
 * 
 */
package com.poc.ai.models;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

/**
 * @author IMRAN
 *
 */
public class SentenceRevealer implements AiModel {

	public SentenceRevealer() {
		// public constructor
	}

	@Override
	public void execute(String paragraph) throws IOException {
		// always start with a model, a model is learned from training data
		InputStream inputStream = null;
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream("en-sent.bin");
			SentenceModel model = new SentenceModel(inputStream);
			SentenceDetectorME sdetector = new SentenceDetectorME(model);

			String[] sentences = sdetector.sentDetect(paragraph);

			for (String sentence : sentences)
				System.out.println(sentence);

		} finally {
			if (Objects.nonNull(inputStream))
				inputStream.close();
		}
	}

}
