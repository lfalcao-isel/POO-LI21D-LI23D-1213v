package poo.cryptraider.levels;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileLevel extends Level {

	private String _filePath;

	public FileLevel(String filePath) {
		_filePath = filePath;
	}
	
	@Override
	protected String[] getLevel() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(_filePath));
			
			String line = reader.readLine();
			int numlines = Integer.parseInt(line);
			String []lines = new String[numlines];
			
			for(int i = 0; i < numlines; ++i) {
				lines[i] = reader.readLine();
 			}
			
			return lines;
			
		} catch (FileNotFoundException e) {
			// VERY, VERY IMPORTANT: CHANGE THIS CODE!!!!
			e.printStackTrace();
		} catch (IOException e) {
			// VERY, VERY IMPORTANT: CHANGE THIS CODE!!!!
			e.printStackTrace();
		}
		return null;
		
	}

}
