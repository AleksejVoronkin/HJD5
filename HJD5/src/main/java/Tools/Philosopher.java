package Tools;

public class Philosopher implements Runnable {
    private final int id;
    private final Fork leftFork;
    private final Fork rightFork;
    private int eatingCounter = 0;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (eatingCounter < 3) {
                think();
                if (takeForks()) {
                    eat();
                    putDownForks();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        System.out.println("//Философ " + id + " поел 3 раза и сыт//.");
    }

    private void think() throws InterruptedException {
        System.out.println("Философ " + id + " размышляет.");
        Thread.sleep(((int) (Math.random() * 1000)));
    }

    private void eat() throws InterruptedException {
        System.out.println("Философ " + id + " ест.");
        eatingCounter++;
        Thread.sleep(((int) (Math.random() * 1000)));
    }

    private void putDownForks() {
        leftFork.putDown();
        System.out.println("Философ " + id + " положил вилку " + leftFork.getId() + ".");
        rightFork.putDown();
        System.out.println("Философ " + id + " положил вилку " + rightFork.getId() + ".");
    }

    private boolean takeForks() {
        System.out.println("Философ " + id + " пытается взять вилки.");
        leftFork.pickUp();
        System.out.println("Философ " + id + " поднял вилку " + leftFork.getId() + ".");
        rightFork.pickUp();
        System.out.println("Философ " + id + " поднял вилку " + rightFork.getId() + ".");
        return true;
    }


}
