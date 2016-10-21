import java.util.Scanner;

/*
 * Created by: Michael Balcerzak
 * Created on: Oct-21-2016
 * Created for: ICS4U
 * dally assignment: 6-02
 * Takes a string from the user and reverses it using recursion.
*/
public class Factorial {

	public static int Factor(int number) {
		int factorNumber = 0;
		
		if (number > 0) {
			
			factorNumber = number * (Factor(number- 1));
			
		} 
		
		return factorNumber;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("put a number to do factorial on it");
		int number = input.nextInt();
		
		int factorNumber = Factor(number);
		
		System.out.println(factorNumber);
	}

}
