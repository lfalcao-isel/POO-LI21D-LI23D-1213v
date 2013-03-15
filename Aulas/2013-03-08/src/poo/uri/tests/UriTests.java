package poo.uri.tests;

import poo.uri.Uri;

public class UriTests {
	
	public static void testUriWithHostOnly() {
		
		Uri uriSlb = Uri.createUri("http://www.slbenfica.pt/"); 
		
		//new Uri("http://www.slbenfica.pt/");
		
		assertEquals(uriSlb.getHost(), "www.slbenfica.pt");
		assertEquals(uriSlb.getPort(), -1);
		assertEquals(uriSlb.getPath(), "/");
		assertEquals(uriSlb.getQueryString(), "");
	}
	
	public static void testUriWithPortAbove32765() {
		
		Uri uriSlb = Uri.createUri("http://www.slbenfica.pt:40000/"); 
		
		//new Uri("http://www.slbenfica.pt/");
		
		assertEquals(uriSlb.getHost(), "www.slbenfica.pt");
		assertEquals(uriSlb.getPort(), 40000);
		assertEquals(uriSlb.getPath(), "/");
		assertEquals(uriSlb.getQueryString(), "");
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


	public static void testUriWithHostAndOnePathElement() {
		
		Uri uriSlb = Uri.createUri("http://www.slbenfica.pt/xpto"); 
		
		
		assertEquals(uriSlb.getHost(),"www.slbenfica.pt");
		assertEquals(uriSlb.getPort(), -1);
		assertEquals(uriSlb.getPath(),"/xpto");
		assertEquals(uriSlb.getQueryString(),"");
	}
	
	public static void testUriWithHostAndPathWithThreeElements() {
		
		Uri uriSlb = Uri.createUri("http://www.slbenfica.pt/xpto/ypto/zpto"); 
		
		
		assertEquals(uriSlb.getHost(),"www.slbenfica.pt");
		assertEquals(uriSlb.getPort(),-1);
		assertEquals(uriSlb.getPath(),"/xpto/ypto/zpto");
		assertEquals(uriSlb.getQueryString(),"");
	}
	
	
	public static void testUriWithHostAndPort() {
		
		Uri uriSlb = Uri.createUri("http://www.slbenfica.pt:8080/"); 
		
		
		assertEquals(uriSlb.getHost(),"www.slbenfica.pt");
		assertEquals(uriSlb.getPort(), 8080);
		assertEquals(uriSlb.getPath(),"/");
		assertEquals(uriSlb.getQueryString(),"");
	}
	
	
	public static void testUriWithQueryString() {
		Uri uriSlb = Uri.createUri("http://www.slbenfica.pt:8080/?benficaomaior"); 
		
		
		assertEquals(uriSlb.getHost(),"www.slbenfica.pt");
		assertEquals(uriSlb.getPort(), 8080);
		assertEquals(uriSlb.getPath(),"/");
		assertEquals(uriSlb.getQueryString(),"benficaomaior");
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
