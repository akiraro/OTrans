import java.io.Serializable;

public class BusStop implements Serializable {
	private static final long serialVersionUID = 1L;
	int stopNo;
	String description, stopID;

	public BusStop(String stopID, int stopNo, String description) {
		this.stopID = stopID;
		this.stopNo = stopNo;
		this.description = description;

	}

	public String toString() {
		return ("stopID : " + stopID + "\nStopNo : " + stopNo + "\nDescription : " + description);
	}
}
