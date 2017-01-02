import java.io.Serializable;

public class Bus implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int no,direction,tripId;
	String description;
	public Bus(int no, int tripId, int direction, String description){
		this.no = no;
		this.direction = direction;
		this.tripId = tripId;
		this.description = description;
		
	}
	
	public int getNo(){	return no; }
	public int getId(){ return tripId; }
	public int getDirection(){ return direction; }
	public String getDescription(){ return description; }
	public String toString(){
		return("Bus Number : " + no + "\nTrip Id : " + tripId + "\nDirection : " + direction + "\nDescription : " + description);
	}
	
	
}
