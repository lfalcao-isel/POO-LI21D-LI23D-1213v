package poo.uri.tests;

import poo.uri.Uri;

public class UriTests {

	//
	// Test auxiliary methods
	//
	
	private static Uri assertUri(String uriStr, String schema, String host, int port, String path) {
		Uri uri = Uri.createUri(uriStr);
		
		assertEquals(uri.getSchema(), schema);
		assertEquals(uri.getHost(), host);
		assertEquals(uri.getPort(), port);
		assertEquals(uri.getPath(),path);
		return uri;
	}
	
	private static void assertUriHttp(String uriStr, String host, int port, String path, String qs) {
		Uri uri = assertUri(uriStr, "http", host, port, path);
		assertEquals(uri.getQueryString(), qs);
	}
	
	private static void assertUriFtp(String uriStr, String host, int port, String path, String type) {
		Uri uri = assertUri(uriStr, "ftp", host, port, path);
		assertEquals(uri.getType(), type);
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
	// Test Methods for Http Schema
	//

	public static void testUriWithHostOnly() {
		assertUriHttp("http://www.slbenfica.pt/", "www.slbenfica.pt", -1, "/", "");
	}
	
	public static void testUriWithPortAbove32765() {
		assertUriHttp("http://www.slbenfica.pt:40000/", "www.slbenfica.pt", 40000, "/", "");
	}

	
	public static void testUriWithHostAndOnePathElement() {
		assertUriHttp("http://www.slbenfica.pt/xpto", "www.slbenfica.pt", -1, "/xpto", "" );
	}
	
	public static void testUriWithHostAndPathWithThreeElements() {
		assertUriHttp("http://www.slbenfica.pt/xpto/ypto/zpto", "www.slbenfica.pt", -1, "/xpto/ypto/zpto", "" );
	}
	
	
	public static void testUriWithHostAndPort() {
		assertUriHttp("http://www.slbenfica.pt:8080/", "www.slbenfica.pt", 8080, "/", "" );
		
	}
	
	
	public static void testUriWithQueryString() {
		
		assertUriHttp("http://www.slbenfica.pt:8080/?benficaomaior", 
				"www.slbenfica.pt", 8080, "/", "benficaomaior" );
	}
	
	
	// 
	// FTP uri tests
	//
	
	
	public static void testftpUriUriWithQueryString() {
		assertUriFtp("ftp://slbenfica.pt/a/b/c?type=a",
				"slbenfica.pt", -1, "/a/b/c", "a");
		
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println("Begin Tests Uri");
		
		testUriWithPortAbove32765();
		testUriWithHostOnly();
		testUriWithHostAndOnePathElement();
		testUriWithHostAndPathWithThreeElements();
		testUriWithHostAndPort();
		testUriWithQueryString();
		testftpUriUriWithQueryString();
		
		System.out.println("End Tests Uri");
	}


}
