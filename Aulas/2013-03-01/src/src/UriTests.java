
public class UriTests {
	
	public static void testUriWithHostOnly() {
		
		Uri uriSlb = Uri.createUri("http://www.slbenfica.pt/"); 
		
		//new Uri("http://www.slbenfica.pt/");
		
		assert(uriSlb.getHost() == "www.slbenfica.pt");
		assert(uriSlb.getPort() == -1);
		assert(uriSlb.getPath() == "/");
		assert(uriSlb.getQueryString() == "");
	}
	
	public static void testUriWithHostAndOnePathElement() {
		
		Uri uriSlb = Uri.createUri("http://www.slbenfica.pt/xpto"); 
		
		
		assert(uriSlb.getHost() == "www.slbenfica.pt");
		assert(uriSlb.getPort() == -1);
		assert(uriSlb.getPath() == "/xpto");
		assert(uriSlb.getQueryString() == "");
	}
	
	public static void testUriWithHostAndPathWithThreeElements() {
		
		Uri uriSlb = Uri.createUri("http://www.slbenfica.pt/xpto/ypto/zpto"); 
		
		
		assert(uriSlb.getHost() == "www.slbenfica.pt");
		assert(uriSlb.getPort() == -1);
		assert(uriSlb.getPath() == "/xpto/ypto/zpto");
		assert(uriSlb.getQueryString() == "");
	}
	
	
	public static void testUriWithHostAndPort() {
		
		Uri uriSlb = Uri.createUri("http://www.slbenfica.pt:8080/"); 
		
		
		assert(uriSlb.getHost() == "www.slbenfica.pt");
		assert(uriSlb.getPort() == 8080);
		assert(uriSlb.getPath() == "/");
		assert(uriSlb.getQueryString() == "");
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Begin Tests Uri");
		
		
		testUriWithHostOnly();
		testUriWithHostAndOnePathElement();
		testUriWithHostAndPathWithThreeElements();
		testUriWithHostAndPort();
		
		System.out.println("End Tests Uri");
	}


}
