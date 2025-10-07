package DesignPatterns.SOLID.OpenorClosedPrinciple.Example;
class Shape{
    String type;
    double dimension; // e.g., radius for circle, side for square
    public Shape(String type) {
        this.type = type;
        this.dimension = dimension;
    }

}
class ShapeCalculatorUglyCode {
    private final Shape shape;

    public ShapeCalculatorUglyCode(Shape shape) {
       this.shape = shape;
    }
    public double calculateArea(Shape shape) {
        //Initial implementation
        if(shape.type.equals("Circle")){
            //Calculate area of circle
            return Math.PI * Math.pow(shape.dimension, 2);
        } else if(shape.type.equals("Square"))
            //Calculate area of square
            return Math.pow(shape.dimension, 2);
        return 0;
    }
    double calculatePerimeter(Shape shape) {
        //Initial implementation
        if(shape.type.equals("Circle")){
            //Calculate perimeter of circle
            return 2 * Math.PI * shape.dimension;
        } else if(shape.type.equals("Square"))
            //Calculate perimeter of square
            return 4 * shape.dimension;
        return 0;
    }
}
// The above code violates the Open/Closed Principle because adding a new shape requires modifying the ShapeCalculator class.
//Suppose we want to add a new shape, like a Rectangle and Triangle. We would have to modify the calculateArea and calculatePerimeter methods to include logic for the new shape.




//Open/Closed Principle Compliant Code
interface IShape {
    double calculateArea();
    double calculatePerimeter();
}
class Circle implements IShape {
    private final double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Square implements IShape {
    private final double side;
    public Square(double side) {
        this.side = side;
    }
    @Override
    public double calculateArea() {
        return Math.pow(side, 2);
    }
    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}
class Rectangle implements IShape {
    private final double length;
    private final double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    @Override
    public double calculateArea() {
        return length * width;
    }
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

class Triangle implements IShape {
    private final double base;
    private final double height;
    private final double sideA;
    private final double sideB;
    private final double sideC;
    private final String triangleType;
    public Triangle(double base, double height, double sideA, double sideB, double sideC, String triangleType) {
        this.base = base;
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.triangleType = triangleType;
    }
    @Override
    public double calculateArea() {
        if(triangleType.equals("Equilateral") && sideA == sideB && sideB == sideC){
            return (Math.sqrt(3) / 4) * Math.pow(sideA, 2);
        } else if(triangleType.equals("Isosceles") && (sideA == sideB || sideB == sideC || sideA == sideC)){
            return (base * height) / 2;
        } else if(triangleType.equals("Scalene")){
            double s = (sideA + sideB + sideC) / 2;
            return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        }
        return 0;
    }
    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }
}

class ShapeCalculator {
    public double calculateArea(IShape shape) {
        return shape.calculateArea();
    }
    public double calculatePerimeter(IShape shape) {
        return shape.calculatePerimeter();
    }
}
class OpenOrClosedPrinciple {
    public static void main(String[] args) {
        IShape circle = new Circle(5);
        IShape square = new Square(4);
        IShape rectangle = new Rectangle(4, 6);
        IShape equilateralTriangle = new Triangle(0, 0, 5, 5, 5, "Equilateral");
        IShape isoscelesTriangle = new Triangle(4, 5, 4, 4, 6, "Isosceles");
        IShape scaleneTriangle = new Triangle(0, 0, 3, 4, 5, "Scalene");

        ShapeCalculator calculator = new ShapeCalculator();

        System.out.println("Circle Area: " + calculator.calculateArea(circle));
        System.out.println("Circle Perimeter: " + calculator.calculatePerimeter(circle));

        System.out.println("Square Area: " + calculator.calculateArea(square));
        System.out.println("Square Perimeter: " + calculator.calculatePerimeter(square));

        System.out.println("Rectangle Area: " + calculator.calculateArea(rectangle));
        System.out.println("Rectangle Perimeter: " + calculator.calculatePerimeter(rectangle));

        System.out.println("Equilateral Triangle Area: " + calculator.calculateArea(equilateralTriangle));
        System.out.println("Equilateral Triangle Perimeter: " + calculator.calculatePerimeter(equilateralTriangle));

        System.out.println("Isosceles Triangle Area: " + calculator.calculateArea(isoscelesTriangle));
        System.out.println("Isosceles Triangle Perimeter: " + calculator.calculatePerimeter(isoscelesTriangle));

        System.out.println("Scalene Triangle Area: " + calculator.calculateArea(scaleneTriangle));
        System.out.println("Scalene Triangle Perimeter: " + calculator.calculatePerimeter(scaleneTriangle));
    }
}
