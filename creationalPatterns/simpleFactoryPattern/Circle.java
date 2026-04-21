package creationalPatterns.simpleFactoryPattern;

public class Circle implements Shape {
    @Override
    public void computeArea() {
        System.out.println("Circle: Area computed");
    }
}
