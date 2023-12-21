// Parent class
class Animal {

}

interface Run {
    void run(); // Method to be implemented by classes
}

interface Speak {
    void speak(); 
}


class Dog extends Animal implements Run, Speak {
    @Override
    public void run() {
        System.out.println("Dog is running");
    }

    @Override
    public void speak() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal implements Run, Speak {
    @Override
    public void run() {
        System.out.println("Cat is running");
    }

    @Override
    public void speak() {
        System.out.println("Cat meows");
    }
}


class Shark extends Animal {
    
}


class HomeAnimal<T extends Animal & Run & Speak> {
    private T animal;

    public HomeAnimal(T animal) {
        this.animal = animal;
    }

    public T getAnimal() {
        return animal;
    }

    public void showClassType() {
        System.out.println(animal.getClass().getName());
    }

    public void sleepOnTheCouch() {
        System.out.println("Sleeping on the couch");
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating Dog and Cat objects using HomeAnimal class
        HomeAnimal<Dog> homeDog = new HomeAnimal<>(new Dog());
        HomeAnimal<Cat> homeCat = new HomeAnimal<>(new Cat());

        
        homeDog.getAnimal().run();
        homeDog.getAnimal().speak();
        homeDog.sleepOnTheCouch();

        homeCat.getAnimal().run();
        homeCat.getAnimal().speak();
        homeCat.sleepOnTheCouch();

    }
}
