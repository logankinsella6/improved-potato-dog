// Written by Logan Kinsella, kinse124 and Aaron Siddiky, siddi186
import java.awt.Color;

public class Circle {
    
    private double X_POS;
    private double Y_POS;
    private double radius;
    private Color color;

    public Circle(double initX_POS, double initY_POS, double initRadius) {
        this.X_POS = initX_POS;
        this.Y_POS = initY_POS;
        this.radius = initRadius;
    }

    public double calculatePerimeter() {
        return 2 * radius * Math.PI;
    }

    public double calculateArea() {
        return Math.PI * (radius * radius);
    }

    public void setColor(Color newColor) {
        color = newColor;
    }

    public void setPos(double newX_POS, double newY_POS){
        X_POS = newX_POS;
        Y_POS = newY_POS;
    }

    public void setRadius(double newRadius) {
        radius = newRadius;
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

    public double getRadius() {
        return radius;
    }
}
