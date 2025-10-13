// Base class representing a motorized IVehicle
package DesignPatterns.SOLID.LiskovSubstitutionPrinciple;
interface Flyable{
    void fly();
}

abstract class Birdd{
    public abstract void eat();
    public abstract void makeSound();
    public abstract void makeNest();
}

class EagleBird extends Birdd implements Flyable {
    @Override
    public void eat() {
        System.out.println("Eagle is eating");
    }

    @Override
    public void makeSound() {
        System.out.println("Eagle screeches");
    }

    @Override
    public void makeNest() {
        System.out.println("Eagle is making a nest");
    }

    @Override
    public void fly() {
        System.out.println("Eagle is flying high");
    }
}

class OstrichBird extends Birdd {
    @Override
    public void eat() {
        System.out.println("Ostrich is eating");
    }

    @Override
    public void makeSound() {
        System.out.println("Ostrich makes a booming sound");
    }

    @Override
    public void makeNest() {
        System.out.println("Ostrich is making a nest");
    }
}

class BirdWatcherr{
    public void watchBird(Birdd bird){
        bird.eat();
        bird.makeSound();
        bird.makeNest();
        if(bird instanceof Flyable){
            ((Flyable) bird).fly();
        } else {
            System.out.println("This bird can't fly");
        }
    }
}
public class LISPCode {
    public static void main(String[] args) {
        BirdWatcherr watcher = new BirdWatcherr();
        Birdd eagle = new EagleBird();
        Birdd ostrich = new OstrichBird();

        watcher.watchBird(eagle); // Works fine
        watcher.watchBird(ostrich); // Works fine, no exception
    }
}