import java.util.Scanner;
import java.util.ArrayList;

public class TripPoint {
	double lat;
	double lon;
	int time;
	ArrayList<TripPoint> trip = new ArrayList<TripPoint>();
	
	public TripPoint(int time, double lat, double lon) {
		time = this.time;
		lat = this.lat;
		lon = this.lon;
	}
	
	
	public int getTime() { //returns time in min
		return time;
	}
	
	public double getLat() {
		return lat;
	}
	
	public double getLon() {
		return lon;
	}
	
	public double getTrip() {
		
	}
	
	//public static getTrip() {}

//------------------------------------------------------------------------
	
	public double haversineDistance(TripPoint a, TripPoint b) {
		
	}
	
	public double totalDistance() {
		
	}
	
	public double avgSpeed() {
		
	}
	
	public double totalTime() {//return time in hours
		double timeHours;
		return timeHours = time/60;
	}
	
	public static void readFile(String filename) {
		
	}
}
