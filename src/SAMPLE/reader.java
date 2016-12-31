package SAMPLE;
import java.io.*;
import java.util.*;

public class reader {

	  public Scanner x;
  	  String[][] trips = new String[1000][1000];
  	  int index = 0;
  	  
	  public void openFile(){
	    try{
	      x = new Scanner(new File("E://trips.txt"));
	    }
	    catch(Exception e){
	    	System.out.println("File is not found");
	    }
	  }
	    public void readFile(){
	    	
	    	
	    	while(index != 1000){
	    		x.useDelimiter(",");
	    		trips[index] = x.nextLine().split(",");
	    		index++;
	    	}
	    }
	    
	    public void print(){
	    	for (int i=0;i<1000;i++){
	    		System.out.println(trips[i][0]);

	    	}
	    }
	    
	    public void closeFile(){
	    	x.close();
	    }
	    

	
}
