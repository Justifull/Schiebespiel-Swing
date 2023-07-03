package game;

public class Main {

    // Main-Methode um das GUI aufzubauen.
    public static void main(String[] args) {
        Model m = new Model();
        View v = new View(m);
        Controller c = new Controller(m, v);
        c.start();
    }
}