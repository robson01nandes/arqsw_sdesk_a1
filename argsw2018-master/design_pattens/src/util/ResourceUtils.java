package util;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * 
 * @author Lucas Nagaoka | RA: 81513916
 *
 */
public final class ResourceUtils {

	public static URL getResourceAsURL(String name) {
		return getContextClassLoader().getResource(name);
	}

	public static String getResourceAsString(String name) {
		URL resource = getResourceAsURL(name);
		return (resource == null) ? null : resource.getPath();
	}

	public static File getResourceAsFile(String name) {
		String resource = getResourceAsString(name);
		return (resource == null) ? null : new File(resource);
	}

	public static InputStream getResourceAsStream(String name) {
		return getContextClassLoader().getResourceAsStream(name);
	}

	private static ClassLoader getContextClassLoader() {
		return Thread.currentThread().getContextClassLoader();
	}
}
