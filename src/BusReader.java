import java.io.*;
import java.util.*;

//constructor//
public class BusReader {
	public BusReader(Bus[][] bus) {
		this.openFile();
		this.readFile(bus);
		this.print();
		this.closeFile();
	}

	public Scanner x;
	String[][] data = new String[760][2];

	public void openFile() {
		try {
			x = new Scanner(new File("C://Users//HAFIZI//Desktop//OC TRANSPO//DATA//routes.txt"));
		} catch (Exception e) {
			System.out.println("File is not found");
		}
		
		try {
			y = new Scanner(new File("C://Users//HAFIZI//Desktop//OC TRANSPO//DATA//trips.txt"));
		} catch (Exception e) {
			System.out.println("File is not found");
		}
	}

	public void readFile(Bus[][] bus) {
		x.nextLine();
		while (x.hasNextLine()) {
			x.useDelimiter(",");

			String[] temp = x.nextLine().split(",");
			try {
				int number = Integer.parseInt(temp[1]);
				data[number][0] = temp[0];
				data[number][0] = temp[0];
			} catch (Exception d) {
				data[750][0] = temp[0];
				data[750][0] = temp[0];
			}
		}
	}

	//Debug method//
	public void print() {
		for (int i = 0; i < 751; i++) {
			System.out.println(data[i][0]);

		}
	}

	public void closeFile() {
		x.close();
	}

}
