package structuralPatterns.DecoratorPattern2;

public class Main {
    public static void main(String[] args) {
        // create 2 base Pizzas :
        // 1: Margherita and then add cheese, olive,cheese
        // 2: Farmhouse and then add olive only.

        Pizza pizza1 = new MargheritaPizza();
        pizza1 = new CheeseDecorator(pizza1);
        pizza1 = new OliveDecorator(pizza1);
        pizza1 = new CheeseDecorator(pizza1);

        System.out.println(pizza1.getDescription());
        System.out.println(pizza1.getCost());

        Pizza pizza2 = new FarmhousePizza();
        pizza2 = new OliveDecorator(pizza2);

        System.out.println(pizza2.getDescription());
        System.out.println(pizza2.getCost());
    }
}

// The javac compiler converts Java source code into platform-independent
// bytecode stored in .class files, which are then executed by the JVM

// How to run?
// javac structuralPatterns/DecoratorPattern2/*.java --> creates .class file
// java structuralPatterns.DecoratorPattern2.Main --> runs main file