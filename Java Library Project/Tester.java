/**
 * Evan Waddell
 * Sean Armbruster 
 * 
 * CSC 251 420
 * Library Project 
 * 
 * This is the tester program to test the methods from the AllInOne Class via a library.
 * 
 */


import net.dtcc.lib.*;

public class Tester
{

	public static void main(String[] args)
	{
		// calling the AllInOne Class
		AllInOne test = new AllInOne();
	
		System.out.println("Area of a Rectangle: " + test.areaRectangle(4, 5));
		System.out.println("Area of a Square: " + test.areaSquare(5));
		System.out.println("Area of a Triangle: " + test.areaTriangle(4,6));
		System.out.println("Area of a Circle: " + test.areaCircle(3));
		System.out.println("Area of a Trapezoid: " + test.areaTrapezoid(4, 8, 3));
		System.out.println("Area of an Ellipse: " + test.areaEllipse(4, 7));
		System.out.println("Area of a Pentagon: " + test.areaPentagon(3, 2.30825));
		System.out.println("Area of a Parallelogram: " + test.areaParallelogram(4, 12));
		System.out.println("Area of a Rhombus: " + test.areaRhombus(3, 2));
		System.out.println("Area of a Hexagon: " + test.areaHexagon(4,4));
		System.out.println("Area of a Polygon: " + test.areapolygon(4, 4, 6));
		System.out.println(" ");
		System.out.println("Addition Fraction test: " + test.addFrac(4, 2, 8, 12));
		System.out.println("Subtraction Fraction test: " + test.subFrac(5, 7, 2, 9));
		System.out.println("Mulitiplication Fraction test: " + test.multFrac(3, 11, 5, 4));
		System.out.println("Division of Fraction test: " + test.divFrac(5, 9, 5, 7));
		System.out.println(" ");
		System.out.println("Binary Conversion test: " + test.binaryToDecimal("11011"));
		System.out.println(" ");
		System.out.println("Celsius to Fahrenheit: " + test.CtoF(55));
		System.out.println("Celsius to Kelvin: " + test.CtoK(35));
		System.out.println("Fahrentheit to Celsius: " + test.FtoC(68));
		System.out.println("Fahrenheit to Kelvin: " + test.FtoK(80));
		System.out.println(" ");
		System.out.println("Volume of a Cube: " + test.volCube(7));
		System.out.println("Volume of a Box: " + test.volBox(4,9,7));
		System.out.println("Volume of a Cylinder: " + test.volCylinder(5,8));
		System.out.println("Volume of a Cone: " + test.volCone(6,4));
		System.out.println("Volume of a Sphere: " + test.volSphere(6));
		System.out.println(" ");
		System.out.println("Perimeter of a Square: " + test.perSquare(9));
		System.out.println("Perimeter of a Rectangle: " + test.perRectangle(4,7));
		System.out.println(" ");
		System.out.println("Circumference of a Circle: " + test.cirCircle(4));
		System.out.println("Pythagorean Theorem: " + test.pythagTheorum(4, 6));

		
	}// end main 

}// end Tester 
