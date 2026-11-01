import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class TripPoint {
	private double lat;
	private double lon;
	private int time;
	private static ArrayList<TripPoint> trip = new ArrayList<TripPoint>();
	
	public TripPoint(int time, double lat, double lon) {
		this.time = time;
		this.lat = lat;
		this.lon = lon;
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
	
	public ArrayList<TripPoint> getTrip() {
		return new ArrayList<>(trip);
	}

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
		File doc = new File(filename);
		try {
			Scanner scan = new Scanner(doc);
			
			if(scan.hasNextLine()) //SHOULD skipp the header 
			{scan.nextLine();}
		
		while(scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] stuff = line.split(",");
			
			int time1 = Integer.parseInt(stuff[0]);
			double latitude = Double.parseDouble(stuff[1]);
			double longitude = Double.parseDouble(stuff[2]);
			
			TripPoint data = new TripPoint(time1, latitude, longitude);
			trip.add(data);
		}
		
		scan.close();
	}
		catch (FileNotFoundException e) {
			System.out.println("No file");
			e.printStackTrace();
		}
		
	}
}
