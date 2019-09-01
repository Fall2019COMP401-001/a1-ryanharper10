package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		int count = scan.nextInt();
				
		for (int i=0; i<count; i++) {
			String firstname = scan.next();
			String lastname = scan.next();
			int numberofitems = scan.nextInt();
			double sum = 0;
			String realsum = "";
			
			for (int j = 0; j < numberofitems; j++) {
				int quantity = scan.nextInt();
				String itemname = scan.next();
				double price = scan.nextDouble();
				double total = quantity * price;
				
				sum += total;
				realsum = String.format("%.2f", sum)
			}
			
			System.out.println(firstname.charAt(0) + ". " + lastname + ": " + realsum);
		}
		
	}
}
