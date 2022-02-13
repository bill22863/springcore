package com.study.springcore.case06;

public class CircleImpl implements Circle{
	private double radius;
	private double area;
	
	@Override
	public double getRoundArea() {
		area = Math.PI * Math.pow(radius, 2);
		return area;
	}

	@Override
	public void setRadius(double r) {
		// TODO Auto-generated method stub
		this.radius = r;
	}

	@Override
	public double getRadius() {
		// TODO Auto-generated method stub
		return radius;
	}

}
