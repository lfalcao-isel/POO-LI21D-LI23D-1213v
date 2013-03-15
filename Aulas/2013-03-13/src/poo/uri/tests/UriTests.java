package poo.uri.tests;

import poo.uri.Uri;

public class UriTests {

	//
	// Test auxiliary methods
	//
	
	private static void assertUri(String uriStr, String host, int port, String path, String qd) {
		Uri uri = Uri.createUri(uriStr);
		assertEquals(uri.getHost(), host);
		assertEquals(uri.getPort(), port);
		assertEquals(uri.getPath(),path);
		assertEquals(uri.getQueryString(), qd);
	}

	
	private static void assertEquals(String actual, String expected) {
		if(expected.equals(actual) == false) {
			System.out.println("Expected " + expected + " actual value is " + actual);
			assert(expected.equals(actual));
		}
		
	}
	
	private static void assertEquals(int actual, int expected) {
		if(expected != actual) {
			System.out.println("Expected " + expected + " actual value is " + actual);
			assert(expected == actual);
		}
		
	}

	
	//
	// Test Methods
	//

	public static void testUriWithHostOnly() {
		assertUri("http://www.slbenfica.pt/", "www.slbenfica.pt", -1, "/", "");
	}
	
	public static void testUriWithPortAbove32765() {
		assertUri("http://www.slbenfica.pt:40000/", "www.slbenfica.pt", 40000, "/", "");
	}

	
	public static void testUriWithHostAndOnePathElement() {
		assertUri("http://www.slbenfica.pt/xpto", "www.slbenfica.pt", -1, "/xpto", "" );
	}
	
	public static void testUriWithHostAndPathWithThreeElements() {
		assertUri("http://www.slbenfica.pt/xpto/ypto/zpto", "www.slbenfica.pt", -1, "/xpto/ypto/zpto", "" );
	}
	
	
	public static void testUriWithHostAndPort() {
		assertUri("http://www.slbenfica.pt:8080/", "www.slbenfica.pt", 8080, "/", "" );
		
	}
	
	
	public static void testUriWithQueryString() {
		
		assertUri("http://www.slbenfica.pt:8080/?benficaomaior", 
				"www.slbenfica.pt", 8080, "/", "benficaomaior" );
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Begin Tests Uri");
		
		testUriWithPortAbove32765();
		testUriWithHostOnly();
		testUriWithHostAndOnePathElement();
		testUriWithHostAndPathWithThreeElements();
		testUriWithHostAndPort();
		testUriWithQueryString();
		
		System.out.println("End Tests Uri");
	}


}
