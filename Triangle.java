// Written by Logan Kinsella, kinse124 and Aaron Siddiky, siddi186
import java.awt.Color;

public class Triangle {
    
    private double X_POS;
    private double Y_POS;
    private double width;
    private double height;
    private Color color;
    private double sideLength;

    public Triangle(double initX_POS, double initY_POS, double initWidth, double initHeight) {
        this.X_POS = initX_POS;
        this.Y_POS = initY_POS;
        this.width = initWidth;
        this.height = initHeight;
    }

    public double calculatePerimeter() {
        sideLength = Math.sqrt(((width/2.0) * (width/2.0)) + (height * height));

        return 2 * sideLength + width;
    }

    public double calculateArea() {
        return (width * height) / 2.0;
    }

    public void setColor(Color newColor) {
        color = newColor;
    }

    public void setPos(double newX_POS, double newY_POS) {
        X_POS = newX_POS;
        Y_POS = newY_POS;
    }

    public void setHeight(double newHeight) {
        height = newHeight;
    }

    public void setWidth(double newWidth) {
        width = newWidth;
    }

    public Color getColor() {
        return color;
    }

    public double getXPos() {
        return X_POS;
    }

    public double getYPos() {
        return Y_POS;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}