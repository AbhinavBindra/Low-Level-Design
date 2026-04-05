import java.util.ArrayList;
import java.util.List;

interface FitnessDataObserver {
    void updateFitnessData(FitnessData data);
}

// 2: Subject Interface
interface FitnessDataSubject {
    void registerObserver(FitnessDataObserver observer);

    void removeObserver(FitnessDataObserver observer);

    void notifyObservers();
}

// 3: Concrete Subject
class FitnessData implements FitnessDataSubject {
    private int steps;
    private int calories;
    private int activeMinutes;

    private final List<FitnessDataObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(FitnessDataObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(FitnessDataObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (FitnessDataObserver observer : observers) {
            observer.updateFitnessData(this);
        }
    }

    public void newFitnessDataPushed(int steps, int activeMinutes, int calories) {
        this.steps = steps;
        this.activeMinutes = activeMinutes;
        this.calories = calories;

        System.out.println("\nFitnessData: New data received: Steps: " + steps +
                ", Active Minutes: " + activeMinutes + ", Calories: " + calories);

        notifyObservers();
    }

    public void dailyReset() {
        this.steps = 0;
        this.activeMinutes = 0;
        this.calories = 0;

        System.out.println("\nFitnessData: Daily reset performed.");
        notifyObservers();
    }

    // Getters
    public int getSteps() {
        return steps;
    }

    public int getActiveMinutes() {
        return activeMinutes;
    }

    public int getCalories() {
        return calories;
    }

};

// 4: Concrete Observer
class LiveActivityDisplay implements FitnessDataObserver {
    @Override
    public void updateFitnessData(FitnessData data) {
        System.out.println("Live Display: Steps: " + data.getSteps() +
                " | Active Minutes: " + data.getActiveMinutes() +
                " | Calories: " + data.getCalories());
    }
}

class ProgressLogger implements FitnessDataObserver {
    @Override
    public void updateFitnessData(FitnessData data) {
        System.out.println("Logger: Saving to DB: Steps=" + data.getSteps() +
                ", ActiveMinutes=" + data.getActiveMinutes() +
                ", Calories=" + data.getCalories());
        // Simulated DB/file write...
    }
}

class GoalNotifier implements FitnessDataObserver {
    private final int stepGoal = 10000;
    private boolean goalReached = false;

    @Override
    public void updateFitnessData(FitnessData data) {
        if (data.getSteps() >= stepGoal && !goalReached) {
            System.out.println("Notifier : Goal Reached! You've hit " + stepGoal + " steps!");
            goalReached = true;
        }
    }

    public void reset() {
        goalReached = false;
    }
}

// 5: Client Code
public class FitnessAppObserverDemo {
    public static void main(String[] args) {
        FitnessData fitnessData = new FitnessData();

        LiveActivityDisplay display = new LiveActivityDisplay();
        ProgressLogger logger = new ProgressLogger();
        GoalNotifier notifier = new GoalNotifier();

        // Register observers
        fitnessData.registerObserver(display);
        fitnessData.registerObserver(logger);
        fitnessData.registerObserver(notifier);

        // Simulate updates
        fitnessData.newFitnessDataPushed(500, 5, 20);
        fitnessData.newFitnessDataPushed(9800, 85, 350);
        fitnessData.newFitnessDataPushed(10100, 90, 380);

        // Remove logger and reset notifier
        fitnessData.removeObserver(logger);
        notifier.reset();
        fitnessData.dailyReset();
    }
}