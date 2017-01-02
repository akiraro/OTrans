import java.io.*;
import java.util.*;

//constructor//
public class BusReader {
	Bus[][] bus;
	public BusReader(Bus[][] bus) {
		this.bus = bus;

	}

	public Scanner x, y;
	String[][][] data = new String[760][2000][4];

	public void openFile() {
		try {
			x = new Scanner(new File("routes.txt"));
		} catch (Exception e) {
			System.out.println("File is not found");
			e.printStackTrace();
		}

		try {
			y = new Scanner(new File("trips.txt"));
		} catch (Exception e) {
			System.out.println("File is not found");
			e.printStackTrace();
		}
	}

	public Bus[][] readFile(Bus[][] bus) {
		// get direction and description//
		/*
		 * 0-bus number 1-direction 2-trip id 3-description
		 */
		y.nextLine();
		while (y.hasNextLine()) {
			y.useDelimiter(",");
			String[] temp = y.nextLine().split(",");
			int number = Integer.parseInt(temp[0].split("-")[0]);
			int number2 = 0 ;
			while (data[number][number2][0] != null){
				number2++;
			}
			data[number][number2][0] = temp[0];
			data[number][number2][1] = temp[4];
			data[number][number2][2] = temp[2].split("-")[0];
			data[number][number2][3] = temp[3];
		}
		
		// create bus class //
		for (int i = 0 ; i<760 ; i++){
			int count = 0;
			//System.out.println(data[i][count][0]);
			while(data[i][count][0] != null){
				Bus tempBus = new Bus(i,Integer.parseInt(data[i][count][2]),Integer.parseInt(data[i][count][1]),data[i][count][3]);
				bus[i][count] = tempBus;
				count++;
			}
		}
		return bus;
	}

	// Debug method//
	public void print() {
		/*for (int i = 0; i < 751; i++) {
			System.out.printf("%s %s %s %s", data[i][0][0], data[i][0][1], data[i][0][2], data[i][0][3]);
			System.out.println("");
			}
			*/
	}

	public void closeFile() {
		x.close();
	}
	
	public Bus[][] init(){
		this.openFile();
		Bus[][] temp12 = this.readFile(bus);		
		this.closeFile();
		return temp12;
	}

}
