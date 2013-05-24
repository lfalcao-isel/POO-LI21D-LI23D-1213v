package poo;

public class FileSystemResourceManager {

	public static String getResource(String resourceName) {
		return ClassLoader.getSystemResource(resourceName)
				.getPath().substring(1);
	}

}
