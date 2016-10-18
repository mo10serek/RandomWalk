/*
 * Created by: Michael Balcerzak
 * Created on: 16-Oct-2016
 * Created for: ICS4U
 * Weekly Assignment – #3
 * This program makes a point makes a trail until it reach the target
*/

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Toolkit;

public class RandomWalk extends JPanel implements ActionListener {

	//this class represents the form
		Timer t = new Timer(5, this);
		Random rnd = new Random();

		//make a list
		private Points p;
		private ArrayList<Points> trail = new ArrayList<Points>();
		
		//make a last point in the list
		private int listScanner;
		private Points get;
		private Ellipse2D.Double lastBlock;
		
		private int testX = 30;
		private int testY = 30;
		
		public void paintComponent(Graphics g) {
			
			//this function draws all the points
			
			Scanner input = new Scanner(System.in);
			Random rnd = new Random();
			
			if ((20 < RandomWalkFrame.sizeOfTargetWidth) && (RandomWalkFrame.sizeOfTargetWidth < 100) && (20 < RandomWalkFrame.sizeOfTargetHeight) && (RandomWalkFrame.sizeOfTargetHeight < 100)) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;

				// make the target
				g2.setColor(Color.RED);
				Ellipse2D.Double target = new Ellipse2D.Double(RandomWalkFrame.randomXLocationTarget, RandomWalkFrame.randomYLocationTarget, RandomWalkFrame.sizeOfTargetWidth, RandomWalkFrame.sizeOfTargetHeight);
				g2.fill(target);
				
				// put the first point
				if(trail.size() == 0) {
					p = new Points(RandomWalkFrame.pointX, RandomWalkFrame.pointY, 5);
					trail.add(p);
				}
				
				//draw more points
				for(int i = 0; i < trail.size(); i++) {
					trail.get(i).draw(g2);
				}
				
				//start drawing
				t.start();
				
				//make the last point
				listScanner = trail.size() - 1;
				get = trail.get(listScanner);
				
				g2.setColor(Color.blue);
				lastBlock = new Ellipse2D.Double(get.getXCoor(), get.getYCoor(), get.getWidth(), get.getHeight());
				g2.fill(lastBlock);
				
				// checking
				System.out.println(RandomWalkFrame.pointX + " " + getWidth() + " " + RandomWalkFrame.pointY + " " + getHeight());
				
			} else {
				
				System.out.println("invaled input");
				
			}
				
			}
			
		public void actionPerformed(ActionEvent e){
			// this helps to move the point make make a trail of points
			int nextLocation = rnd.nextInt(4) + 1;
			
			//moving the point and make a trail
			if (nextLocation == 1) { // right
				if (getWidth() - 5 < RandomWalkFrame.pointX) {
					AddPointLeft();
				}
				else {
					AddPointRight();
				}
			}
			else if (nextLocation == 2)  { // left
				if (RandomWalkFrame.pointX < 0) {
					AddPointRight();
				}
				else {
					AddPointLeft();
				}
			}
			else if (nextLocation == 3)  { // up
				if (getHeight() - 5 < RandomWalkFrame.pointY) {
					AddPointDown();
				}
				else {				
					AddPointUp();
				}
			}
			else if (nextLocation == 4)  { // down
				if (RandomWalkFrame.pointY < 0) {
					AddPointUp();
				}	
				else {
					AddPointDown();
				}
			}
			
			//add a new point to the class
			trail.add(p);
			
			//stop the prosses
			if (!(lastBlock.intersects(RandomWalkFrame.randomXLocationTarget, RandomWalkFrame.randomYLocationTarget, RandomWalkFrame.sizeOfTargetWidth, RandomWalkFrame.sizeOfTargetHeight))){
				repaint();
			}
				
		}
		
		public void AddPointUp() {
			//move point up
			p = new Points(RandomWalkFrame.pointX, RandomWalkFrame.pointY + 5, 5);
			RandomWalkFrame.pointY = RandomWalkFrame.pointY + 5;
		}
		
		public void AddPointDown() {
			// move point down
			p = new Points(RandomWalkFrame.pointX, RandomWalkFrame.pointY - 5, 5);
			RandomWalkFrame.pointY = RandomWalkFrame.pointY - 5;
		}
		
		public void AddPointRight() {
			// move point right
			p = new Points(RandomWalkFrame.pointX + 5, RandomWalkFrame.pointY, 5);
			RandomWalkFrame.pointX = RandomWalkFrame.pointX + 5;
		}
		
		public void AddPointLeft() {
			// move point left
			p = new Points(RandomWalkFrame.pointX - 5, RandomWalkFrame.pointY, 5);
			RandomWalkFrame.pointX = RandomWalkFrame.pointX - 5;
		}
		
}
