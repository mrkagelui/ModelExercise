import java.util.Collections;

class Animal {
}

interface Talkable {
    void talk();
}

interface Swimmable {
    void swim();
}

interface Flyable {
    void fly();
}

interface Walkable {
    void walk();
}

interface Singable {
    void sing();
}

class Bird extends Animal implements Walkable {
    void sing() {
        System.out.println("I am singing");
    }
    public void walk() {
        System.out.println("I am walking");
    }
}

class Duck extends Bird implements Swimmable, Talkable, Flyable {
    public void fly() {
        System.out.println("I am flying");
    }
    public void swim() {
        System.out.println("I am swimming");
    }

    public void talk() {
        System.out.println("Quack, quack");
    }
}

class Chicken extends Bird {
    public void talk() {
        System.out.println("Cluck, cluck");
    }
}

class Rooster extends Bird {
    public void talk() {
        System.out.println("Cock-a-doodle-doo");
    }
}

class Dog extends Animal implements Talkable {
    public void talk() {
        System.out.println("Woof, woof");
    }
}

class Cat extends Animal implements Talkable {
    public void talk() {
        System.out.println("Meow");
    }
}

class Parrot extends Bird implements Singable {
    Talkable neighbor;

    public Parrot(Talkable t) {
        neighbor = t;
    }

    public void talk() {
        if (null != neighbor) neighbor.talk();
    }

    public void sing() {
        System.out.println("Parrot singing!");
    }
}

class Fish extends Animal implements Swimmable {
    protected Size size;
    protected Color color;
    public void swim() {
        System.out.println("I'm swimming!");
    }
}

enum Size {
    LARGE,
    SMALL
}

enum Color {
    GREY,
    ORANGE
}

class Shark extends Fish {
    public Shark() {
        size = Size.LARGE;
        color = Color.GREY;
    }

    public void eat(Fish f) {
        System.out.println("Yum!");
    }
}

class ClownFish extends Fish {
    public ClownFish() {
        size = Size.SMALL;
        color = Color.ORANGE;
    }

    public void joke() {
        System.out.println("Broken pencils are pointless.");
    }
}

class Dolphin extends Animal implements Swimmable {
    public void swim() {
        System.out.println("Swimming");
    }
}

class Butterfly extends Animal implements Flyable {
    public void fly() {
        System.out.println("Butterfly flying!");
    }
}

class CaterPillar extends Animal implements Walkable {
    public void walk() {
        System.out.println("Caterpillar crawling");
    }

    public Butterfly grow() {
        return new Butterfly();
    }
}

public class Solution {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{ new Bird(),
                new Duck(),
                new Chicken(),
                new Rooster(),
                new Parrot(new Dog()),
                new Fish(),
                new Shark(),
                new ClownFish(),
                new Dolphin(),
                new Dog(),
                new Butterfly(),
                new Cat()
        };

        int flyables = 0, walkables = 0, singables = 0, swimmables= 0;
        for (Animal a : animals) {
            if (a instanceof Flyable) flyables++;
            if (a instanceof Walkable) walkables++;
            if (a instanceof Singable) singables++;
            if (a instanceof Swimmable) swimmables++;
        }

        System.out.println(String.format("Out of %d animals, %d can fly," +
                " %d can walk, %d can sing, %d can swim", animals.length,
                flyables, walkables, singables, swimmables));
    }
}