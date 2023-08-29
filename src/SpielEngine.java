import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class SpielEngine {
    ArrayList<Player> spielerListe = new ArrayList<>();

    public ArrayList<Player> generatePlayers(){
        System.out.println("Willkommen bei Fabians total einfachem, kreuzdämlichen Trinkspiel.\nDie Regeln sind ganz einfach: Wessen Thread zuletzt ankommt muss einen trinken.");
        System.out.println("Wieviele Spieler möchten spielen?");
        Scanner spielerAnzahlScanner = new Scanner(System.in);
        int spielerAnzahl = spielerAnzahlScanner.nextInt();
        for (int i = 1; i <spielerAnzahl+1 ; i++) {
            System.out.println("Wie lautet der Name von Spieler"+i+"?");
            Scanner spielerNameScanner = new Scanner(System.in);
            String spielerName = spielerNameScanner.nextLine();
            Player p1 = new Player(spielerName);
            spielerListe.add(p1);
        }
        return spielerListe;
    }

    public ArrayList<RaceThread> initiateGame(ArrayList<Player> liste){
        ArrayList<RaceThread> threadListe = new ArrayList<>();
        System.out.println("Wie weit sollen die Threads laufen müssen?");
        Scanner distanceScanner = new Scanner(System.in);
        int distance = distanceScanner.nextInt();
        for (Player p:liste) {
            RaceThread rt1 = new RaceThread(p.name,distance);
            threadListe.add(rt1);
        }
    return threadListe;}

    public void startGame(ArrayList<RaceThread> list){
        System.out.println("Sind Sie bereit?");
        Scanner bereitScanner = new Scanner(System.in);
        String bereit = bereitScanner.nextLine().toLowerCase();
        switch (bereit){
            case "nein": {
                System.out.println("Dann halt nicht du dusselige Kuh. Trink doch allein");
                System.exit(0);

            }
            default: for (RaceThread r: list) {
                r.start();
            }

        }
    }

}
