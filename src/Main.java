import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
SpielEngine e1 = new SpielEngine();
ArrayList<RaceThread> liste = e1.initiateGame(e1.generatePlayers());
e1.startGame(liste);
    }
}