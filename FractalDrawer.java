// Written by Aaron Siddiky, siddi186 and Logan Kinsella, kinse124
// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.util.Scanner;
import java.util.Random;

public class FractalDrawer {
    private double totalArea=0.0;  // member variable for tracking the total area

    public FractalDrawer() {

    }  // constructor


    public Color randColor() {
        // Create a random object
        Random random = new Random();

        // Generate random values for red, green, and blue components
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        // Create a Color object with the random RGB values
        Color randomColor = new Color(red, green, blue);

        return randomColor;
    }


    //TODO:
    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String shapeType) {
        if (shapeType.equals("circle")){
            Canvas drawing = new Canvas(800, 800);
            drawCircleFractal(150,300,300, randColor(), drawing, 0); 
            return totalArea;
        } else if(shapeType.equals("triangle")) {
            Canvas drawing = new Canvas(800, 800);
            drawTriangleFractal(200, 200, 300, 500, randColor(), drawing, 0);
            return totalArea;
        } else if(shapeType.equals("rectangle")) {
            Canvas drawing = new Canvas(800, 800);
            drawRectangleFractal(200, 200, 400, 400, randColor(), drawing, 0);
            return totalArea;
        } else {
            System.out.println("Invalid input.");
            return -1.0;
        }
        
    }


    //TODO:
    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
        if (level == 7) {
            return;
        } else {
            Triangle createTriangle = new Triangle(x, y, width, height);
            createTriangle.setColor(randColor());
            can.drawShape(createTriangle);
            totalArea += createTriangle.calculateArea();

            drawTriangleFractal(width / 1.75, height / 1.75, x - (width / 1.75), y, c, can, level + 1);
            drawTriangleFractal(width / 1.75, height / 1.75, x + (width / 1.75)*1.75, y, c, can, level + 1);
            drawTriangleFractal(width / 1.75, height / 1.75, x + ((width / 1.75) / 2.75), y - (height), c, can, level + 1);
        }
    }


    // TODO:
    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        double shift = radius + radius*0.5; //the offeset to shift for the radius
        if (level == 7) {
            return;
        } else {
            Circle createCircle = new Circle(x, y, radius);
            createCircle.setColor(randColor());
            can.drawShape(createCircle);
            totalArea += createCircle.calculateArea();

            drawCircleFractal(radius/2, x + shift, y , c, can, level + 1);
            drawCircleFractal(radius/2, x, y + shift, c, can, level + 1);
            drawCircleFractal(radius/2, x - shift, y, c, can, level + 1);
            drawCircleFractal(radius/2, x, y - shift , c, can, level + 1);

        }
    
    }

    //TODO:
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        if (level == 7) {
            return;
        } else {
            Rectangle createRectangle = new Rectangle(x, y, width, height);
            createRectangle.setColor(randColor());
            can.drawShape(createRectangle);
            totalArea += createRectangle.calculateArea();

            drawRectangleFractal(width/2, height/2, x - (width/2), y + height/2 + height/4, c, can, level + 1);
            drawRectangleFractal(width/2, height/2, x + width/2 + width/4, y + height/2 + height/4 , c, can, level + 1);
            drawRectangleFractal(width/2, height/2, x - width/2, y - height/2, c, can, level + 1);
            drawRectangleFractal(width/2, height/2, x + width/2 + width/4, y - height/2 , c, can, level + 1);

        }
    
    }

    //TODO:
    // main should ask user for shape input, and then draw the corresponding fractal.
    // should print area of fractal
    public static void main(String[] args){
        System.out.print("Enter a shape type (circle, triangle, rectangle): ");
        Scanner myScanner = new Scanner(System.in);
        String shapeType = myScanner.nextLine();
        FractalDrawer fractalDrawer = new FractalDrawer();
        System.out.println("The total area for the fractal is " + fractalDrawer.drawFractal(shapeType));
        myScanner.close();
    }
}