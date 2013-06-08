package trabalho2.g1;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Grupo1 {
	/*
	 * 1. copia para o stream pw o conteúdo do ficheiro de texto com pathname
	 * pathnameIn, substituindo cada ocorrência do carácter '\t' por n
	 * caracteres espaço
	 */
	public static void replaceTabs(String pathnameIn, PrintWriter pw, int n ) throws IOException {
		FileReader reader  = null;
		try {
			reader = new FileReader(pathnameIn);
		
		char []chars = new char[100];
		
		StringBuffer sb = new StringBuffer();
		for(; n != 0; --n) {
			sb.append(' ');
		}
		String spaces = sb.toString();
		
		int numChars;
		do {
			numChars = reader.read(chars);
			String s = new String(chars, 0, numChars);
			s.replace("\t", spaces);
			pw.write(s.toCharArray());
		} while(true);
		} finally {
			if(reader != null) {
				reader.close();
			}
		}
	}
}
