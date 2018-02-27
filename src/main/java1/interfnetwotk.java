import java.io.IOException;
import java.util.Scanner;

public class interfnetwotk {
	public static void main(String[] args) throws IOException {
	    String os = System.getProperty("os.name").toLowerCase();

	  if (os.contains("nix") || os.contains("nux") || os.contains("mac os x")) {
	        System.out.println("Unix-like computer name through env:\"" + System.getenv("192.168.1.12") + "\"");
	        System.out.println("Unix-like computer name through exec:\"" + execReadToString("hostname") + "\"");
	        System.out.println("Unix-like computer name through /etc/hostname:\"" + execReadToString("cat /etc/hostname") + "\"");
	    }
	}

	@SuppressWarnings("resource")
	public static String execReadToString(String execCommand) throws IOException {
	    try (Scanner s = new Scanner(Runtime.getRuntime().exec(execCommand).getInputStream()).useDelimiter("\\A")) {
	        return s.hasNext() ? s.next() : "";
	    }
	}

}
