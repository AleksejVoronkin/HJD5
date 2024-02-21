package Tools;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    private final Lock lock = new ReentrantLock();
    private final int id;

    public Fork(int id) {
        this.id = id;
    }

    public void pickUp() {
        lock.lock();
    }

    public void putDown() {
        lock.unlock();
    }

    public int getId() {
        return id;
    }
}
