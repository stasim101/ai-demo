/**
 * 
 */
package com.poc.ai.models;

import java.io.IOException;

/**
 * @author IMRAN
 *
 */
public interface AiModel {

	public void execute(String paragraph) throws  IOException;

}
