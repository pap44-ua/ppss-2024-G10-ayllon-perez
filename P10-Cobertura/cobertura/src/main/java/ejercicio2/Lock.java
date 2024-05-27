package ejercicio2;

public class Lock {
    private int keyValue;
    private boolean locked;

    public Lock(int keyValue) {
        this.keyValue = keyValue;
        locked = true;
    }

    public boolean unlock (int keyValue) {
        if (this.keyValue == keyValue) {
            locked = false;
        } else {
            locked = true;
        }
        return !locked;
    }

    public void lock() {
        locked = true;
    }

    public boolean isLocked() {
        return locked;
    }
}
