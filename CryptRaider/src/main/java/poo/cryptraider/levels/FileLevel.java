package poo.cryptraider.levels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.System.*;


import poo.cryptraider.exceptions.CryptRaiderException;
import poo.cryptraider.exceptions.LoadLevelException;

public class FileLevel extends Level {

	private String _filePath;
	
	System s;

	public FileLevel(String filePath) {
		_filePath = filePath;
	}
	
	//@Override
	protected String[] getLevel() throws CryptRaiderException {
		try {
			java.io.BufferedReader reader = new BufferedReader(
				new FileReader(_filePath)
			);
			
			String line = reader.readLine();
			int numlines = Integer.parseInt(line);
			String []lines = new String[numlines];
			
			for(int i = 0; i < numlines; ++i) {
				lines[i] = reader.readLine();
 			}
			
			return lines;
			
		} catch (IOException e) {
			throw new LoadLevelException("Eroor loading level", e);
		}
	}

}
