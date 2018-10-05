package model.entities;

import model.enums.Color;

public class Circle extends AbstractShape {
	private Double radius;

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return Math.PI * radius * radius;
	}

	public Circle(Color color, Double radius) {
		super(color);
		this.radius = radius;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

}
