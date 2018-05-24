import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void birdCanSing() {
        Bird bird = new Bird();
        bird.sing();
        assertEquals("I am singing\n", outContent.toString());
    }

    @Test
    public void duckTest() {
        Duck duck = new Duck();
        duck.fly();
        assertEquals("I am flying\n", outContent.toString());
        outContent.reset();
        duck.swim();
        assertEquals("I am swimming\n", outContent.toString());
        outContent.reset();
        duck.talk();
        assertEquals("Quack, quack\n", outContent.toString());
    }

    @Test
    public void chickenTest() {
        Chicken c = new Chicken();
        c.talk();
        assertEquals("Cluck, cluck\n", outContent.toString());
    }

    @Test
    public void roosterTest() {
        Rooster r = new Rooster();
        r.talk();
        assertEquals("Ohkohkohkohkohh\n", outContent.toString());
    }

    @Test
    public void parrotTest() {
        Parrot p0 = new Parrot(new Dog());
        p0.talk();
        assertEquals("Woof, woof\n", outContent.toString());
        outContent.reset();
        Parrot p1 = new Parrot(new Cat());
        p1.talk();
        assertEquals("Meow\n", outContent.toString());
    }

    @Test
    public void fishTest() {
        Fish f = new Fish();
        f.swim();
        assertEquals("I'm swimming!\n", outContent.toString());
    }

    @Test
    public void sharkTest() {
        Shark s = new Shark();
        s.eat(new Fish());
        assertEquals("Yum!\n", outContent.toString());
    }

    @Test
    public void clownFishTest() {
        ClownFish cf = new ClownFish();
        cf.joke();
        assertEquals("Broken pencils are pointless.\n", outContent.toString());
    }

    @Test
    public void dolphinTest() {
        Dolphin d = new Dolphin();
        d.swim();
        assertEquals("Swimming\n", outContent.toString());
    }

    @Test
    public void butterflyTest() {
        Butterfly b = new Butterfly();
        b.fly();
        assertEquals("Butterfly flying!\n", outContent.toString());
    }

    @Test
    public void caterpillarTest() {
        CaterPillar george = new CaterPillar();
        george.walk();
        assertEquals("Caterpillar crawling\n", outContent.toString());
        outContent.reset();
        Butterfly georgeReformed = george.grow();
        georgeReformed.fly();
        assertEquals("Butterfly flying!\n", outContent.toString());
    }
}