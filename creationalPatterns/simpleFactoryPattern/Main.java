package creationalPatterns.simpleFactoryPattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("===========SIMPLE FACTORY DESIGN PATTERN============");
        ShapeType shapeType = ShapeType.CIRCLE;
        Shape shapeByClient = ShapeFactory.createShapeInstance(shapeType);
        shapeByClient.computeArea();
    }
}
