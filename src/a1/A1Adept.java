package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		int itemsinstore = scan.nextInt();
		double[] prices = new double[itemsinstore];
		String[] itemnames = new String[itemsinstore];
		
		for (int i = 0; i < itemsinstore; i++) {
			String name = scan.next();
			double price = scan.nextDouble();
			
			itemnames[i] = name;
			prices[i] = price;
		}
		
		int numofcust = scan.nextInt();
		String[] customerlist = new String[numofcust];
		double[] items = new double[numofcust];
		
		for (int i = 0; i < numofcust; i++) {
			String firstname = scan.next();
			String lastname = scan.next();
			int numofitems = scan.nextInt();
			
			customerlist[i] = firstname + " " + lastname;
			
			for (int j = 0; j < numofitems; j++) {
				int quantity = scan.nextInt();
				String itemname = scan.next();
				
				items[i] += nameToPrice(itemname, itemnames, prices) * quantity;
			}
		}
		
		double max = max(items);
		String maxname = matchName(max, items, customerlist);
		System.out.println("Biggest: " + maxname + " (" + max + ")");
		
		double min = min(items);
		String minname = matchName(min, items, customerlist);
		System.out.println("Smallest: " + minname + " (" + min + ")");
		
		double average = average(items);
		String avg = String.format("%.2f", average);
		System.out.println("Average: " + avg);
				
	}
	
	public static double nameToPrice(String name, String[] names, double[] prices) {
		for (int i = 0; i < names.length; i++) {
			if (name.equals(names[i])) {
				return prices[i];
			}
		}
		
		return 0;
	}
	
	public static String matchName(double max, double[] prices, String[] names) {
		for (int i = 0; i < prices.length; i++) {
			double price = prices[i];
			
			if (max == price) {
				return names[i];
			}
		}
		
		return " ";
	}
	
	public static double max(double[] prices) {
		double largest = 0;
		
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] > largest) {
				largest = prices[i];
			}
		}
		
		return largest;
	}
	
	public static double min(double[] prices) {
		double smallest = prices[0];
		
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < smallest) {
				smallest = prices[i];
			}
		}
		
		return smallest;
	}
	
	public static double average(double[] prices) {
		double avg = 0;
		
		for (int i = 0; i < prices.length; i++) {
			avg += prices[i];
		}
		
		avg /= prices.length;
		return avg;
	}
}
