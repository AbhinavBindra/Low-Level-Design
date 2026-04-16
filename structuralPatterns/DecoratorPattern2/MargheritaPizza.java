package structuralPatterns.DecoratorPattern2;
//What do I need in decorator pattern?

// 1: I need concrete Component (multiple base pizzas like margherita and farmhouse)
// 2: I need interface component (acts as the component and defines the common contract for both base pizzas and decorators.)
// 3: I need abstract decorator (which will implement coomponent interface, holds reference to component obj enabling recursive wrapping and delegates default behaviour)
// 4: I need concrete decorators (which will actually add toppings)
// 5: I need the client code that will dynamically compose pizzas by wrapping base objects with decorators at runtime

// Interface Component
// public interface Pizza {

//     String getDescription();

//     double getCost();
// }

// Concrete Component 1
public class MargheritaPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Base: Margherita";
    }

    @Override
    public double getCost() {
        return 10;
    }
}

// // Concrete Component 2
// public class FarmhousePizza implements Pizza {
// @Override
// public String getDescription() {
// return "Base: Farmhouse";
// }

// @Override
// public double getCost() {
// return 15;
// }
// }

// // Abstract Decorator
// public abstract class PizzaDecorator implements Pizza { // is-a relationship
// created
// protected Pizza pizza; // has-a relationship

// public PizzaDecorator(Pizza pizza) {
// this.pizza = pizza;
// }

// @Override
// public String getDescription() {
// return pizza.getDescription();
// }

// @Override
// public double getCost() {
// return pizza.getCost();
// }
// }

// // “Each decorator augments behavior by delegating to the wrapped object and
// // adding its own logic."
// public class CheeseDecorator extends PizzaDecorator { // is-a relationship
// public CheeseDecorator(Pizza pizza) {
// super(pizza);
// }

// @Override
// public String getDescription() {
// return pizza.getDescription() + " + cheese";
// }

// @Override
// public double getCost() {
// return pizza.getCost() + 3;
// }
// }

// public class OliveDecorator extends PizzaDecorator {
// public OliveDecorator(Pizza pizza) {
// super(pizza);
// }

// @Override
// public String getDescription() {
// return pizza.getDescription() + " + Olive";
// }

// @Override
// public double getCost() {
// return pizza.getCost() + 2;
// }

// }

// Benefit of override: “It ensures that a method correctly overrides a
// superclass or interface method, providing compile-time safety and preventing
// subtle bugs caused by signature mismatches."

// public class Main {
// public static void main(String[] args) {
// // create 2 base Pizzas :
// // 1: Margherita and then add cheese, olive,cheese
// // 2: Farmhouse and then add olive only.

// Pizza pizza1 = new MargheritaPizza();
// pizza1 = new CheeseDecorator(pizza1);
// pizza1 = new OliveDecorator(pizza1);
// pizza1 = new CheeseDecorator(pizza1);

// System.out.println(pizza1.getDescription());
// System.out.println(pizza1.getCost());

// Pizza pizza2 = new FarmhousePizza();
// pizza2 = new OliveDecorator(pizza2);

// System.out.println(pizza2.getDescription());
// System.out.println(pizza2.getCost());
// }
// }