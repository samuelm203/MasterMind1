import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner spielregel = new Scanner(System.in);

        System.out.println("Kennst du das Spiel MasterMind?");
        String entscheidung1 = spielregel.nextLine();

        while (entscheidung1 == "ja") {
            System.out.println("Die möglichen Farben sind: Rot, Blau, Grün, Gelb, Pink, Schwarz, Grau und Orange");
        }

        while (entscheidung1 == "nein") {
            System.out.println("Spielregeln:\n" +
                    "\n" +
                    "Es gibt eine versteckte Farbenfolge, die aus vier Farben besteht\n" +
                    "\n" +
                    "Dabei dürfen die Farben doppelt vorkommen.\n" +
                    "\n" +
                    "Es gibt die Farben: Blau, Rot, Grün, Gelb, Orange, Violet\n" +
                    "\n" +
                    "Als Spieler gibst du in der Konsole eine Farbfolge ein (durch ein Leerzeichen getrennt.)\n" +
                    "\n" +
                    "Das Spiel gibt die eine Rückmeldung (X ein Farbe ist korrekt und am richtigen Platz, 0 eine Farbe ist Korekkt aber steht am falschen Platz. _ nicht in der geheimen Farbfolge.)\n" +
                    "\n" +
                    "Das Spiel endet, wenn du die richtige Reihenfolge innert 12 Versuchen errätst.\n" +
                    "\n" +
                    "Ansonsten hast du nach 12 Versuchen verloren.");
        }

        System.out.println("Gib entweder ja oder nein ein!");
    }

}
