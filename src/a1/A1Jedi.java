package a1;

import java.util.Scanner;

public class A1Jedi {

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
		
		int[] custnum = new int[itemsinstore];
		int[] quantity = new int[itemsinstore];
		String[] custfirst = new String[itemsinstore];
		String[] custlast = new String[itemsinstore];
		int people = scan.nextInt();
		
		for (int i = 0; i < people; i++) {
			custfirst[i] = scan.next();
			custlast[i] = scan.next();
			int numofitems = scan.nextInt();
			boolean[] repeatitem = new boolean[itemsinstore];
			
			for (int j = 0; j < numofitems; j++) {
				int quant = scan.nextInt();
				String itemname = scan.next();
				nametoquant(itemname, quant, itemnames, quantity);
				nametonum(itemname, i, itemnames, custnum, repeatitem);
			}
		}
		
		for (int i = 0; i < itemsinstore; i++) {
			if (custnum[i] == 0) {
				System.out.println("No customers bought " + itemnames[i]);
			} else {
				System.out.println(custnum[i] + " customers bought " + quantity[i] + " " + itemnames[i]);
			}
		}
		
	}
	
	public static double nametoquant(String itemname, int quant, String[] itemnames, int[] quantity) {
		for (int i = 0; i < itemnames.length; i++) {
			if (itemname.contentEquals(itemnames[i])) {
				return quantity[i] += quant;
			}
		}
		
		return 0;
	}
	
	public static double nametonum(String itemname, int x, String[] itemnames, int[] custnum, boolean[] repeatitem) {
		for (int i = 0; i < itemnames.length; i++) {
			if (itemname.equals(itemnames[i]) && !repeatitem[i]) {
				repeatitem[i] = true;
				
				return custnum[i] += 1;
			}
		}
		return 0;
	}
}
