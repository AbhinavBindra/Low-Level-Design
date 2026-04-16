package structuralPatterns.DecoratorPattern2;

public abstract class PizzaDecorator implements Pizza { // is-a relationship created
    protected Pizza pizza; // has-a relationship

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }

}
