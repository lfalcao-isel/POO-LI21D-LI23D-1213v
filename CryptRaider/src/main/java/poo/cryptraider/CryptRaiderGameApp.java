package poo.cryptraider;

import java.io.File;

import poo.cryptraider.exceptions.CryptRaiderException;
import poo.cryptraider.levels.FileLevel;
import poo.cryptraider.viewers.ConsoleViewer;
import poo.cryptraider.viewers.Viewer;

public class CryptRaiderGameApp {

	/**
	 * @param args
	 * @throws CryptRaiderException 
	 */
	public static void main(String[] args) throws CryptRaiderException {
		CryptRaider c = new CryptRaider();
		
		//c.start(new Level1());
		String absPath = new File("").getAbsolutePath();
		System.out.println(absPath);
		absPath = ClassLoader.getSystemResource("levels/Level1.txt").getPath().substring(1);
		System.out.println(absPath);
		c.start(new FileLevel(absPath), new ConsoleViewer());
		
		
		

	}

}
