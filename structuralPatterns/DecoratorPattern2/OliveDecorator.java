package structuralPatterns.DecoratorPattern2;

public class OliveDecorator extends PizzaDecorator {
    public OliveDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Olive";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 2;
    }

}