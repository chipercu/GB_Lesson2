package lesson1;

public class Human implements Participants{
    private int maxJumping;
    private int maxRunning;

    public Human(int maxJumping, int maxRunning) {
        this.maxJumping = maxJumping;
        this.maxRunning = maxRunning;
    }

    public int getMaxJumping() {
        return maxJumping;
    }

    public void setMaxJumping(int maxJumping) {
        this.maxJumping = maxJumping;
    }

    public int getMaxRunning() {
        return maxRunning;
    }

    public void setMaxRunning(int maxRunning) {
        this.maxRunning = maxRunning;
    }

    @Override
    public void run() {
        System.out.println("Человек бежит");
    }

    @Override
    public void jump() {
        System.out.println("Человек прыгает");
    }
}
