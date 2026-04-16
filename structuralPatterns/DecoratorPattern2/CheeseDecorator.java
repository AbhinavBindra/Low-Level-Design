package structuralPatterns.DecoratorPattern2;

// "Each decorator augments behavior by delegating to the wrapped object and
// adding its own logic."
public class CheeseDecorator extends PizzaDecorator { // is-a relationship
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 3;
    }
}