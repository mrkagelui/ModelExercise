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
        assertEquals("Cock-a-doodle-doo\n", outContent.toString());
    }
}