import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Reader {
	public Reader() {
	}

	public Object run(String filename) {
		Object data = null;
		try {
			FileInputStream fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			data = ois.readObject();
			ois.close();
			System.out.println("Read completed");

		} catch (Exception e) {
			System.out.println("Error to read the file");
		}
		return data;
	}

}
