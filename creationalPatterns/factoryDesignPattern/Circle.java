package creationalPatterns.factoryDesignPattern;

public class Circle implements Shape {
    @Override
    public void computeArea() {
        System.out.println("Circle: Area Computed");
    }
}
