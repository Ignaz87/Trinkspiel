import java.util.Random;

public class RaceThread extends Thread{
    String iD;
    int distanceTravelled = 0;
    int distanceNeeded;

    public RaceThread(String iD, int distanceNeeded) {
        this.iD = iD;
        this.distanceNeeded = distanceNeeded;
    }

    @Override
    public void run() {

        while (distanceTravelled <distanceNeeded){
            Random random = new Random();
            int turn = random.nextInt(10 - 1 + 1) + 1;
            System.out.println("Thread-"+iD+ " bewegt sich " + turn+"m.");
            distanceTravelled += turn;

            try {
                Thread.sleep(1300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(distanceTravelled>= distanceNeeded){
            System.out.println("Thread-"+iD+" hat das Ziel erreicht!");

        }
        return;
    }
}
