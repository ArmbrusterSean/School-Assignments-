/** 
 * Evan Waddell
 * Sean Armbruster
 * 
 * Library Project
 * 
 * This program creates a library of various methods and tests them in another project via the projectLib.jar file 
 */

package net.dtcc.lib;

public class AllInOne
{
	
//Area of shapes
	public double areaRectangle(double side1, double side2) {
		//width*length
		return side1*side2;	
	}// end areaRectangle
	
	public double areaSquare(double side) {
		//width*width
		return side*side;	
	}// end areaSquare
	
	public double areaTriangle(double base, double height) {
		//.5*base*height
		return .5*base*height;	
	}// end areaTriangle
	
	public double areaCircle(double radius) {
		//pi*r^2
		return Math.PI*(radius*radius);	
	} // end areaCircle
	
	public double areaTrapezoid(double top, double bottom, double height) {
		//((top+bottom)/2)*height
		return ((top+bottom)/2)*height;		
	}// end areaTrapezoid
	
	public double areaEllipse(double radL, double radS) {
		//long radius*short radius*pi
		return radL*radS*Math.PI;
	}//end areaEllipse
	
	public double areaPentagon(double base, double height) {
		//Regular pentagon
		//(.5*side length * distance to center from middle of side) *5
		return (.5*base*height)*5;	
	} // end areaPentagon
	
	public double areaParallelogram(double base, double height) {
		//Base*height
		return base*height;	
	}// end areaParallelogram
	
	public double areaRhombus(double side, double height) {
		//Height*side length
		return side*height;
	}// end areaRhombus
	
	public double areaHexagon(double base, double height) {
		//Regular hexagon
		//(.5*side length * distance to center from middle of side) *6
		return (.5*base*height)*6;
	}// end areaHexagon
	
	public double areapolygon(double base, double height, int n) {
		//regular polygon
		if(n>4) {
			//(.5*side length * distance to center from middle of side) *n
			return (.5*base*height)*n;
		}// end if 
		else if(n==4) {
			//Special behavior for rectangles
			return ((.5*base*height)*n)/2;
		}// end else if 
		else if(n==3) {
			//Special behavior for triangles
			return (.5*base*height);
		}// end else if 
		else{
			//Special behavior for polygons with impossible amount of sides
			return -1;
		}// end else 
	}// end areapolygon
	
	//Fraction operations
	public double addFrac(int num1, int den1, int num2, int den2) {
		//Cast numerator values to float, fixes integer division
		float x=num1;
		float y=num2;
		
		return (x/den1)+(y/den2);
	}// end addFrac
	
	public double subFrac(int num1, int den1, int num2, int den2) {
		//Cast numerator values to float, fixes integer division
				float x=num1;
				float y=num2;
		
		return (x/den1)-(y/den2);
	}// end subFrac
	
	public double multFrac(int num1, int den1, int num2, int den2) {
		//Cast numerator values to float, fixes integer division
				float x=num1;
				float y=num2;
		
		return (x/den1)*(y/den2);
	}//end multFrac
	
	public double divFrac(int num1, int den1, int num2, int den2) {
		//Cast numerator values to float, fixes integer division
				float x=num1;
				float y=num2;
		return (x/den1)/(y/den2);
	}// end divFrac
	
	//Binary to decimal
	public double binaryToDecimal(String binaryIn) {
		//for holding the answer
		double holder1=0;
		double holder2=0;
		//For holding the binary number, in pieces.
		char[] boop=binaryIn.toCharArray();
		//while loop variables
		int max=boop.length;
		int count=0;
			
		while (count<max) {
			holder1= Character.getNumericValue(boop[count]);
			if (holder1==1) {
				holder2+=Math.pow(2, (max-(count+1)));
				count++;
			}// end if 
			else {
				count++;
		    }// end else 
		}// end While
		return holder2;
	}// end binaryToDecimal
	
	//Temperature conversions
	public double CtoF(double tempC) {
		return tempC*9/5+32;	
	} // end CtoF
	
	public double CtoK(double tempC) {
		return tempC-273.15;
	}// end CtoK
	
	public double FtoC(double tempF) {
	    return (tempF-32)*5/9;			
	}// end fToC
	
	public double FtoK(double tempF) {
		return ((tempF-32)*5/9)-273.15;	
	}// end fTok
	
	// Volume of a Cube 
	public double volCube(double a) {
		return Math.pow(a,3);
	}// end volCube
	
	// Volume of a Box
	public double volBox(double l, double w, double h) {
		return l*w*h;
		
	}// end volBox
	
	// Volume of a Cylinder
	public double volCylinder(double r, double h) {
		return Math.PI*Math.pow(r,2)*h;
	}// end volCylinder
	
	// Volume of a Cone
	public double volCone(double r, double h) {
		return Math.PI *Math.pow(r,2)*(h/3);	
	}// end volCone
	
	// Volume of a Sphere
	public double volSphere(double r) {
		return (4.0/3)*(Math.PI)*(Math.pow(r, 3));
	}// end volSphere 
	
	//Perimeter of Square
	public double perSquare(double a) {
		return 4*a;
	}// end perSquare
	
	// Perimeter of Rectangle
	public double perRectangle(double l, double w) {
		return (l*2)+(w*2);
	}// end perRectangle 
	
    // Circumference of a Circle
	public double cirCircle(double r) {
		return 2*Math.PI*r;
	}// end cirCircle 
	
    // Pythagoreum Theorum
	public double pythagTheorum(double a, double b) {
		return Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
	}// end pythagTheorum

}// end AllInOne Class 
