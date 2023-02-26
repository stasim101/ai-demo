/**
 * 
 */
package com.poc.ai;

import java.io.IOException;

import com.poc.ai.models.SentenceRevealer;

/**
 * @author IMRAN
 *
 */
public class Main {

	public static void main(String[] args) {
		SentenceRevealer sentenceRevealer = new SentenceRevealer();
		try {
			sentenceRevealer.execute("Hi. How are you? This is James.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
