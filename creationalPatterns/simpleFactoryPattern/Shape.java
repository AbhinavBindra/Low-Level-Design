// Simple Factory Pattern: is a pattern when we used to encapsulate the object
// creation logic into one place.
// Reason: If in future, the instantation logic changes, we just need to update
// it at one place rather than doing at all places.

// TO DO:
// We create a shapeFactory that will create the desired shape for you.

// Shape Interface
// Concrete Shape 1
// Concrete Shape 2
// Shape Factory
// Client Code

package creationalPatterns.simpleFactoryPattern;

public interface Shape {

    void computeArea();

}