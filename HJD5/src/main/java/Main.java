import Tools.Fork;
import Tools.Philosopher;

public class Main {
    public static void main(String[] args) {
        int philosophersCount = 5;
        Philosopher[] philosophers = new Philosopher[philosophersCount];
        Fork[] forks = new Fork[philosophersCount];

        for (int i = 0; i < philosophersCount; i++) {
            forks[i] = new Fork(i+1);
        }

        for (int i = 0; i < philosophersCount; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % philosophersCount];

            philosophers[i] = new Philosopher(i+1, leftFork, rightFork);
            Thread philosopherThread = new Thread(philosophers[i], "Философ " + (i+1));
            philosopherThread.start();
        }
    }
}