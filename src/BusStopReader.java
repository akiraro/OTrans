import java.io.*;
import java.util.*;

//constructor//
public class BusStopReader {
	BusStop[] busStop = new BusStop[10000];
	public Scanner y;
	String[][] data = new String[10000][3];

	public void openFile() {

		try {
			y = new Scanner(new File("C://Users//HAFIZI//Desktop//DATA//stops.txt"));
		} catch (Exception e) {
			System.out.println("File is not found");
		}
	}

	public BusStop[] readFile() {
		int counter = 0;
		// get direction and description//
		/*
		 * 0-stopID 1-stopNo 2-stopdescription
		 */
		y.nextLine();
		while (y.hasNextLine()) {
			y.useDelimiter(",");
			String[] temp = y.nextLine().split(",");
			data[counter][0] = temp[0];
			data[counter][1] = temp[1];
			data[counter][2] = temp[2];
			counter++;
		}

		// create busStop class //
		for (int i = 0; i < 10000; i++) {
			BusStop temp = new BusStop(data[0][0], Integer.parseInt(data[0][1]), data[i][2]);
			busStop[i] = temp;
		}
		return busStop;

	}

	// Debug method//
	public void print() {
		/*
		 * for (int i = 0; i < 751; i++) { System.out.printf("%s %s %s %s",
		 * data[i][0][0], data[i][0][1], data[i][0][2], data[i][0][3]);
		 * System.out.println(""); }
		 */
	}

	public void closeFile() {
		y.close();
	}

	public BusStop[] init() {
		this.openFile();
		BusStop[] temp = this.readFile();
		this.closeFile();
		return temp;
	}

}