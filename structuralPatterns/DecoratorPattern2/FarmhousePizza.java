package structuralPatterns.DecoratorPattern2;

// Concrete Component 2
public class FarmhousePizza implements Pizza {
    @Override
    public String getDescription() {
        return "Base: Farmhouse";
    }

    @Override
    public double getCost() {
        return 15;
    }
}