import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner spielregel = new Scanner(System.in);

    public static void main(String[] args) {

        Random generator = new Random();
        int counter = 0;
        int richtigerort = 0;
        int richtigefarben = 0;
        int countereins = 1;

        String[] farben = {
                "rot", "blau", "grün", "gelb", "pink", "schwarz", "grau", "orange"
        };

        System.out.println("Kennst du das Spiel MasterMind? Für ja = 1/ Für nein = 2 ");
        int entscheidung1 = Integer.parseInt(spielregel.nextLine());

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

        while (countereins == 1) {

            String farbenzufaellig1 = farben[generator.nextInt(farben.length)];
            String farbenzufaellig2 = farben[generator.nextInt(farben.length)];
            String farbenzufaellig3 = farben[generator.nextInt(farben.length)];
            String farbenzufaellig4 = farben[generator.nextInt(farben.length)];
            richtigefarben = 0;
            richtigefarben = 0;
            counter = 0;

            System.out.println(farbenzufaellig1 + farbenzufaellig2 + farbenzufaellig3 + farbenzufaellig4);
            while (counter <= 12) {

                countereins++;
                counter++;
                richtigefarben = 0;
                richtigerort = 0;

                System.out.print("Gib deine erste Farbe ein: ");
                String eingabeeins = spielregel.nextLine();

                System.out.print("Gib deine zweite Farbe ein: ");
                String eingabezwei = spielregel.nextLine();

                System.out.print("Gib deine dritte Farbe ein: ");
                String eingabedrei = spielregel.nextLine();

                System.out.print("Gib deine vierte Farbe ein: ");
                String eingabevier = spielregel.nextLine();

                if (eingabeeins.equals(farbenzufaellig1)) {
                    richtigerort++;
                }
                if (eingabeeins.equals(farbenzufaellig2)) {
                    richtigefarben++;
                }
                if (eingabeeins.equals(farbenzufaellig3)) {
                    richtigefarben++;
                }
                if (eingabeeins.equals(farbenzufaellig4)) {
                    richtigefarben++;
                }


                if (eingabezwei.equals(farbenzufaellig1)) {
                    richtigefarben++;
                }
                if (eingabezwei.equals(farbenzufaellig2)) {
                    richtigerort++;
                }
                if (eingabezwei.equals(farbenzufaellig3)) {
                    richtigefarben++;
                }
                if (eingabezwei.equals(farbenzufaellig4)) {
                    richtigefarben++;
                }

                if (eingabedrei.equals(farbenzufaellig1)) {
                    richtigefarben++;
                }
                if (eingabedrei.equals(farbenzufaellig2)) {
                    richtigefarben++;
                }
                if (eingabedrei.equals(farbenzufaellig3)) {
                    richtigerort++;
                }
                if (eingabedrei.equals(farbenzufaellig4)) {
                    richtigefarben++;
                }


                if (eingabevier.equals(farbenzufaellig1)) {
                    richtigefarben++;
                }
                if (eingabevier.equals(farbenzufaellig2)) {
                    richtigefarben++;
                }
                if (eingabevier.equals(farbenzufaellig3)) {
                    richtigefarben++;
                }
                if (eingabevier.equals(farbenzufaellig4)) {
                    richtigerort++;
                }


                if (!(richtigerort == 4)) {
                    System.out.println("So viele sind richtig: " + richtigerort +
                            " und so viele sind an falscher Stelle: " + richtigefarben + ".");
                }

                if (richtigerort == 4) {
                    System.out.println("Gratulieren, du hast gewonnen!");
                    System.out.println("Drücke r, um noch eine Runde zuspielen und b um das Spiel zubeenden");
                    String letzteeingabe = spielregel.nextLine();
                    if (letzteeingabe.equals("r")) {
                        countereins = 1;
                    } else {
                        System.exit(0);
                    }
                }


            }
        }
    }
}