
public class Bus {
	int no,direction,tripId;
	String description;
	public Bus(int no, int tripId, int direction, String description){
		no = this.no;
		direction = this.direction;
		tripId = this.tripId;
		description = this.description;
		
	}
	
	public int getNo(){	return no; }
	public int getId(){ return tripId; }
	public int getDirection(){ return direction; }
	public String getDescription(){ return description; }
	public String toString(){
		return("Bus Number : " + no + "\nTrip Id : " + tripId + "\nDirection : " + direction + "\nDescription : " + description);
	}
	
	
}
