// Parent class
class Animal {
    // Common attributes and methods for all animals
}

interface Run {
    void run(); // Method to be implemented by classes
}

interface Speak {
    void speak(); // Method to be implemented by classes
}

// Dog class implementing Run and Speak
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

// Cat class implementing Run and Speak
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

// Shark class which does not implement Run and Speak
class Shark extends Animal {
    // Shark specific methods
}

// HomeAnimal class
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

        // Using HomeAnimal methods
        homeDog.getAnimal().run();
        homeDog.getAnimal().speak();
        homeDog.sleepOnTheCouch();

        homeCat.getAnimal().run();
        homeCat.getAnimal().speak();
        homeCat.sleepOnTheCouch();

        // Trying to create a Shark object (will fail at compile time)
        // HomeAnimal<Shark> homeShark = new HomeAnimal<>(new Shark()); // This line will cause a compilation error
    }
}
