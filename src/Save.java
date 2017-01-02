import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Save {
	Bus[][] obj;
	String filename;
	String[] h = new String[]{"sds","sdsds"};
	public Save(Object obj,String filename){
		this.obj = (Bus) obj;
		System.out.println(obj.getClass());
		this.filename = filename;
		//System.out.println(obj[96][0]);
		run();
	}
	public void run() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
			out.writeObject(h);
			out.flush();
			out.close();
			System.out.println("Saved");
		} catch (Exception e) {
			System.out.println("Fail to save data");
		}
	}
}
