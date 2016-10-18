/*
 * Created by: Michael Balcerzak
 * Created on: 16-Oct-2016
 * Created for: ICS4U
 * Weekly Assignment – #3
 * This program makes a point makes a trail until it reach the target
*/

import javax.swing.JFrame;
import java.awt.Rectangle;
import java.util.Random;
import java.util.Scanner; 

public class RandomWalkFrame {
	//this class makes the static fields and set up the form
	
	//size
	public static int sizeOfFormWidth;
	public static int sizeOfFormHeight;
	public static int sizeOfTargetWidth;
	public static int sizeOfTargetHeight;
	
	//location for the target
	public static int randomXLocationTarget;
	public static int randomYLocationTarget;
	
	//location for the point
	public static int pointX;
	public static int pointY;
	
	public static void main(String[] args) {		
		JFrame randomWalk = new JFrame();
		Random rnd = new Random();
		
		// make the form
		randomWalk.setTitle("random walk");
		randomWalk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RandomWalk DC = new RandomWalk();
				
		Scanner input = new Scanner(System.in);
		
		//inputs
		System.out.println("what is the size of the width of the form. Between 200 to 800");
		sizeOfFormWidth = (int) input.nextDouble();
		
		System.out.println("what is the size of the height of the form. Between 200 to 800");
		sizeOfFormHeight = (int) input.nextDouble();
		
		System.out.println("what is the size of the width of the target. Between 20 to 100");
		sizeOfTargetWidth = (int) input.nextDouble();
		
		System.out.println("what is the size of the height of the target. Between 20 to 100");
		sizeOfTargetHeight = (int) input.nextDouble();
		
		//makes the form and place the objects in a random location
		if ((200 < sizeOfFormWidth) && (sizeOfFormWidth < 800) && (200 < sizeOfFormHeight) && (sizeOfFormHeight <800)) {
			randomWalk.setSize(sizeOfFormWidth, sizeOfFormHeight);
			randomWalk.setVisible(true);
			randomWalk.add(DC);
			
			pointX = rnd.nextInt(RandomWalkFrame.sizeOfFormWidth) + 1; //rnd.nextInt(RandomWalkFrame.sizeOfFormWidth) + 1;
			pointY = rnd.nextInt(RandomWalkFrame.sizeOfFormHeight) + 1;
			
			randomXLocationTarget = rnd.nextInt(RandomWalkFrame.sizeOfFormWidth) + 1;
			randomYLocationTarget = rnd.nextInt(RandomWalkFrame.sizeOfFormHeight) + 1;
		} else {
			
			System.out.println("invaled input");
		}
		
	}

}
