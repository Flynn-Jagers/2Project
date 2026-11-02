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
	
	public static ArrayList<TripPoint> getTrip() {
		return new ArrayList<>(trip);
	}

//------------------------------------------------------------------------
	
	public static double haversineDistance(TripPoint a, TripPoint b) {
		final double RADIUS = 6371.0;
		
		double latidute1 = Math.toRadians(a.getLat());
		double latidute2 = Math.toRadians(b.getLat());
		
		double longA = Math.toRadians(a.getLon());
		double longB = Math.toRadians(b.getLon());
		
		double deltaLatAB = latidute2 - latidute1;
		double deltaLonAB = longB - longA;
		
		double step2 = Math.sin(deltaLatAB / 2) * Math.sin(deltaLatAB / 2) 
				+ Math.cos(latidute1) * Math.cos(latidute2) * Math.sin( deltaLonAB / 2) 
				* Math.sin(deltaLonAB / 2);
		
		double step3 = Math.asin(Math.sqrt(step2));
		
		return RADIUS * step3;
	}
	
	public static double totalDistance() {
		double disTotal = 0.0;
		
		for(int i = 0; i < trip.size() - 1; i++) {
			TripPoint now = trip.get(i);
			TripPoint next = trip.get(i + 1);
			disTotal = disTotal + haversineDistance(now, next);
		}
		
		return disTotal;
	}
	
	public static double avgSpeed(TripPoint a, TripPoint b) {
		//my cat just laid on my arm and trapped it how am i supost to code with one hand?
		//at least shes cute
		
		double distanceAB = haversineDistance(a, b);
		
		double timeMin = Math.abs(a.getTime() - b.getTime());
		
		if (timeMin == 0.0)
		{return 0.0;}
		
		double timeHour = timeMin / 60.0;
		double avgSped = distanceAB / timeHour;
		
		return avgSped;
	}
	
	public static double totalTime() {//return time in hours
		
		int start = trip.get(0).getTime();
		int end = trip.get(trip.size() - 1).getTime();
		
		double minFinal = end - start;
		
		return minFinal / 60.0;
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
			
			int time1 = Integer.parseInt(stuff[0].trim());
			double latitude = Double.parseDouble(stuff[1].trim());
			double longitude = Double.parseDouble(stuff[2].trim());
			
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
