package creationalPatterns.factoryDesignPattern;

import creationalPatterns.simpleFactoryPattern.ShapeType;

public class Main {
    public static void main(String[] args) {
        System.out.println("=========== FACTORY DESIGN PATTERN============");
        ShapeType shapeType = ShapeType.RECTANGLE;
        Shape shape = getShapeInstance(shapeType);
        shape.computeArea();
    }

    public static Shape getShapeInstance(ShapeType shapeType) {
        Shape shape = null;
        if (shapeType == null)
            return null;

        switch (shapeType) {
            case CIRCLE:
                ShapeFactory circleFactory = new CircleFactory();
                shape = circleFactory.createShape();
                break;
            case RECTANGLE:
                ShapeFactory rectangleFactory = new RectangleFactory();
                shape = rectangleFactory.createShape();
                break;
            default:
                throw new IllegalStateException("ShapeType Does not exist");
        }
        return shape;

    }
}
// 1 Factory for 1 Product
// Interface Shape
// Concrete Shape 1
// Concrete Shape 2
// Interface ShapeFactory
// Concrete ShapeFactory 1
// Concrete ShapeFactory 2
// Client Code