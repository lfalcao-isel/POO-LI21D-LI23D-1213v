package poo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class AliceInWorderlandStuff {
	static int countWord(String path, String word) throws IOException {
		
		word = word.toLowerCase();
		
		FileReader fr = null;
		int count = 0;
		try {
			fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while((line = br.readLine()) != null) {
				line = line.toLowerCase();
				
				int idx;
				do {
					
					idx = line.indexOf(word);
					if(idx != -1) {
						++count;
						line = line.substring(idx+word.length());
					}
					
				} while(idx != -1);
			}
			
			
			 
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			closeFile(fr);
		}

		return count;
	}

	private static void closeFile(FileReader fr) {
		try {
			if (fr != null)
				fr.close();
		} catch (IOException e) {
			System.out.println("Error closing file");
		}
	}
	
	private static void closeFile(Writer wr) {
		try {
			if (wr != null)
				wr.close();
		} catch (IOException e) {
			System.out.println("Error closing file");
		}
	}
	
	public static void main(String[] args) throws IOException {
		String aliceFilePath = FileSystemResourceManager.getResource("AliceInWonderland.txt");
		int count = countWord(aliceFilePath, "Alice");
		
		String destinationPath =  aliceFilePath.replace(".txt", "Lines.txt");
		copyLinesWithWord(aliceFilePath, destinationPath, "Alice");
		
		System.out.println(count);
	}

	
	
	private static void copyLinesWithWord(String srcFile,
			String destinationFile, String word) throws IOException {
		word = word.toLowerCase();
		FileReader src = null;
		FileWriter dest = null;
		PrintWriter wr = null;
		try {
			src = new FileReader(srcFile);
			BufferedReader br = new BufferedReader(src);
		
			dest = new FileWriter(destinationFile);
			
			wr = new PrintWriter(dest);
			
			
			String line;
			while((line = br.readLine()) != null) {
				String lowerwedLine = line.toLowerCase();
				int idx = lowerwedLine.indexOf(word);
				if(idx != -1) {
					wr.println(line);
				}
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			closeFile(src);
			closeFile(wr);
		}
	}
	
	private static Collection<String> getLinesWithWord(String srcFile,
			String destinationFile, String word) throws IOException {
		word = word.toLowerCase();
		FileReader src = null;
		FileWriter dest = null;
		PrintWriter wr = null;
		
		
		ArrayList<String> lines = new ArrayList<String>();
		

		
		try {
			src = new FileReader(srcFile);
			BufferedReader br = new BufferedReader(src);
		
			dest = new FileWriter(destinationFile);
			
			wr = new PrintWriter(dest);
			
			
			String line;
			while((line = br.readLine()) != null) {
				String lowerwedLine = line.toLowerCase();
				int idx = lowerwedLine.indexOf(word);
				if(idx != -1) {
					// String was found
					lines.add(line);
					
				}
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			closeFile(src);
			closeFile(wr);
			return lines;
		}
	}
	
	
}