package kihon;

import java.awt.Color;

public enum TrafficLight {
	BLUE,YELLOW,RED;
	private Color[] col = {Color.BLUE,Color.YELLOW,Color.RED};
	public Color getColor() {
		return col[ordinal()];
	}

	public static void main(String[] args) {
		System.out.println(TrafficLight.BLUE);
		System.out.println(TrafficLight.RED.getColor());
	}
}
