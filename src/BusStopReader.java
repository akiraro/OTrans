import java.io.*;
import java.util.*;

//constructor//
public class BusStopReader {
	BusStop[] busStop = new BusStop[10000];
	public Scanner y;

	public void openFile() {

		try {
			y = new Scanner(new File("C://Users//HAFIZI//Desktop//DATA//stops.txt"));
		} catch (Exception e) {
			System.out.println("File is not found");
		}
	}

	public HashMap<String,BusStop> readFile() {
		// get direction and description//
		/*
		 * 0-stopID 1-stopNo 2-stopdescription
		 */
		HashMap<String,BusStop> data = new HashMap<String, BusStop>();
		
		y.nextLine();
		while (y.hasNextLine()) {
			y.useDelimiter(",");
			String[] temp = y.nextLine().split(",");
			try{
			BusStop temp2 = new BusStop(temp[0], temp[1], temp[2],null);
			data.put(temp[0], temp2);
			}
			catch(Exception e){
				System.out.println("Error occured : " + e);
			}	
		}
		return data;

	}

	public void closeFile() {
		y.close();
	}

	public HashMap<String, BusStop> init() {
		this.openFile();
		HashMap<String,BusStop> temp = this.readFile();
		this.closeFile();
		return temp;
	}

}