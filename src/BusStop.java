import java.io.Serializable;

public class BusStop implements Serializable {
	private static final long serialVersionUID = 1L;
	String description, stopID, stopNo;
	Schedule schedule;

	public BusStop(String stopID, String stopNo, String description, Schedule schedule) {
		this.stopID = stopID;
		this.stopNo = stopNo;
		this.description = description;
		this.schedule = new Schedule();

	}

	public String getStopID(){
		return stopID;
	}
	
	public String toString() {
		return ("stopID : " + stopID + "\nStopNo : " + stopNo + "\nDescription : " + description);
	}
}
