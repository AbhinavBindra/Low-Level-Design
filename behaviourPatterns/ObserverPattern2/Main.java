import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

// Subject Interface
interface Subject {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}

// Concrete Subject
class YoutubeChannel implements Subject {
    private List<Observer> subscribers = new ArrayList<>();
    private String latestVideo;

    public void addObserver(Observer o) {
        subscribers.add(o);
    }

    public void removeObserver(Observer o) {
        subscribers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : subscribers) {
            o.update(latestVideo);
        }
    }

    public void uploadVideo(String title) {
        this.latestVideo = title;
        notifyObservers();
    }
}

// Concrete Observer/s
class User implements Observer {
    private String name;

    User(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " got notified: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        // Client Code
        YoutubeChannel channel = new YoutubeChannel();
        Observer user1 = new User("Abhinav");
        Observer user2 = new User("Yuvi");

        channel.addObserver(user1);
        channel.addObserver(user2);

        channel.uploadVideo("Observer Pattern Explained");
    }
};
