class Animal {
    void walk() {
        System.out.println("I am walking");
    }
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

class Bird extends Animal {
    void sing() {
        System.out.println("I am singing");
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

class Chicken extends Bird implements Talkable {
    public void talk() {
        System.out.println("Cluck, cluck");
    }
}

public class Solution {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.walk();
        //bird.fly();
        bird.sing();
    }
}