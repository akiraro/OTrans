
public class Data {

	public static void main(String[] args) {
		//create bus//
		Bus[][] bus = new Bus[760][2000];
		BusReader busReader = new BusReader(bus);
		bus = busReader.init();
		new Save(bus, "Bus");
		Reader reader = new Reader();
		//Bus[][] test = (Bus[][])reader.run("Bus.ser");

		//create bus stop//
		BusStop[] busStop = new BusStop[10000];
		BusStopReader busStopReader = new BusStopReader();
		busStop = busStopReader.init();
		new Save(busStop, "BusStop");
		//BusStop[] test = (BusStop[])reader.run("BusStop.ser");
		
	}

}
