/*
 * Created by: Michael Balcerzak
 * Created on: 16-Oct-2016
 * Created for: ICS4U
 * Weekly Assignment – #3
 * This program makes a point makes a trail until it reach the target
*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Points {
	//This class represents the point sprite and all its felds and methods
	
	private int xCoor;
	private int yCoor;
	private int width;
	private int height;
	
	public Points(int xCoor, int yCoor, int tileSize) {
		// sets all the felds
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		width = tileSize;
		height = tileSize;
	}
	
	public void draw(Graphics g) {
		//draw the point
		g.setColor(Color.BLACK);
		g.fillRect(xCoor, yCoor, width, height);
	}
	
	
	public int getXCoor() {
		//get the xCoor
		return xCoor;
	}
	
	public int getYCoor() {
		//get the yCoor
		return yCoor;
	}
	
	public int getWidth() {
		//get the width
		return width;
	}
	
	public int getHeight() {
		//get the height
		return height;
	}
	
}
