package poo.cryptraider.levels;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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
			Scanner s = new Scanner(new FileInputStream(_filePath));
			
			int numLines = s.nextInt();
			int numCols = s.nextInt();
			s.nextLine();

			String []lines = new String[numLines];
			
			for(int i = 0; i < numLines; ++i) {
				lines[i] = s.nextLine().substring(0, numCols);
 			}
			
			s.close();
			return lines;
			
		} catch (IOException e) {
			throw new LoadLevelException("Eroor loading level", e);
		}
	}

}
