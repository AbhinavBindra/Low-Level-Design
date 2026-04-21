package creationalPatterns.simpleFactoryPattern;

public class ShapeFactory {
    public static Shape createShapeInstance(ShapeType shapeType) {
        if (shapeType == null)
            return null;

        switch (shapeType) {
            case CIRCLE:
                return new Circle();

            case RECTANGLE:
                return new Rectangle();

            default:
                throw new IllegalStateException("ShapeType Does not Exist");
        }
    }
}
