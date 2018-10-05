package model.enums;

import model.entities.AbstractShape;
import model.entities.Circle;
import model.entities.Rectangle;

public class ProgramShape {

	public static void main(String[] args) {
		AbstractShape s1 = new Rectangle(Color.WHITE, 4.0, 3.0);
		AbstractShape s2 = new Circle(Color.BLACK, 2.0);

		System.out.println("Circle Color: " + s2.getColor());
		System.out.println("Circle area:  " + String.format("%.3f", s2.area()));
		System.out.println("Rectangle Color: " + s1.getColor());
		System.out.println("Rectangle area:  " + String.format("%.3f", s1.area()));
	}

}
