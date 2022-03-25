package lesson1;

public class App {

    public static void main(String[] args) {


        final Obstacle wall = new Wall(50);
        final Obstacle treadmill = new Treadmill(100);

        Participants[] participants = {
                new Human(50, 1000),
                new Robot(100, 800),
                new Fish(0 ,0)};

        Obstacle[] obstacles = {
                new Wall(25),
                new Treadmill(200),
                new Wall(50),
                new Treadmill(900)
        };

        for (Participants participant : participants) {
            for (Obstacle obstacle: obstacles) {
                obstacle.begin(participant);
            }
        }
    }
}
