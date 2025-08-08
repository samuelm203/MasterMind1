import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner spielregel = new Scanner(System.in);
        Random generator = new Random();
        int counter = 0;
        int richtigerort = 0;
        int richtigefarben = 0;

        String[] farben = {"Rot", "Blau", "Grün", "Gelb", "Pink", "Schwarz", "Grau", "Orange"};


        System.out.println("Kennst du das Spiel MasterMind? Für ja = 1/ Für nein = 2 ");
        int entscheidung1 = spielregel.nextInt();

        if (entscheidung1 == 1) {
            System.out.println("Die möglichen Farben sind: Rot, Blau, Grün, Gelb, Pink, Schwarz, Grau und Orange");
        }

        if (entscheidung1 == 2) {
            System.out.println("Spielregeln:\n" +
                    "\n" +
                    "Es gibt eine versteckte Farbenfolge, die aus vier Farben besteht\n" +
                    "\n" +
                    "Dabei dürfen die Farben doppelt vorkommen.\n" +
                    "\n" +
                    "Es gibt die Farben: Rot, Blau, Grün, Gelb, Pink, Schwarz, Grau und Orange\n" +
                    "\n" +
                    "Als Spieler gibst du in der Konsole eine Farbfolge ein (durch ein Leerzeichen getrennt.)\n" +
                    "\n" +
                    "Das Spiel gibt die eine Rückmeldung (X ein Farbe ist korrekt und am richtigen Platz, 0 eine Farbe ist Korekkt aber steht am falschen Platz. _ nicht in der geheimen Farbfolge.)\n" +
                     "\n" +
                    "Das Spiel endet, wenn du die richtige Reihenfolge innert 12 Versuchen errätst.\n" +
                    "\n" +
                    "Ansonsten hast du nach 12 Versuchen verloren.");
        }

        String farbenzufaellig1 = farben[generator.nextInt(farben.length)];

        String farbenzufaellig2 = farben[generator.nextInt(farben.length)];

        String farbenzufaellig3 = farben[generator.nextInt(farben.length)];

        String farbenzufaellig4 = farben[generator.nextInt(farben.length)];

            while (counter <= 12) {
                counter++;

                System.out.println("Gib deine erste Farbe ein!");
                String eingabeeins = spielregel.nextLine();

                String eingabezwei = spielregel.nextLine();
                System.out.println("Gib deine zweite Farbe ein!");

                String eingabedrei = spielregel.nextLine();
                System.out.println("Gib deine dritte Farbe ein!");

                String eingabevier = spielregel.nextLine();
                System.out.println("Gib deine vierte Farbe ein!");


            }

    }
}


