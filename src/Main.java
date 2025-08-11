import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner spielregel = new Scanner(System.in);

    public static void main(String[] args) {

        Random generator = new Random();

        String[] farben = {
                "rot", "blau", "grün", "gelb", "pink", "schwarz", "grau", "orange"
        };

        System.out.println("Kennst du die Regeln für das Spiel MasterMind? Für ja = 1 / Für nein = 2 ");
        int entscheidung1 = Integer.parseInt(spielregel.nextLine());

        if (entscheidung1 == 1) {
            System.out.println("Die möglichen Farben sind: Rot, Blau, Grün, Gelb, Pink, Schwarz, Grau und Orange");
        }

        if (entscheidung1 == 2) {
            System.out.println("Spielregeln:\n" +
                    "Es gibt eine versteckte Farbenfolge, die aus vier Farben besteht\n" +
                    "Dabei dürfen die Farben doppelt vorkommen\n" +
                    "Farben: Rot, Blau, Grün, Gelb, Pink, Schwarz, Grau und Orange\n" +
                    "Du gibst nacheinander vier Farben ein\n" +
                    "Maximal 12 Versuche");
        }

        boolean weiterspielen = true;

        while (weiterspielen) {

            // Zufällige Farbfolge
            String[] geheimCode = new String[4];
            for (int i = 0; i < 4; i++) {
                geheimCode[i] = farben[generator.nextInt(farben.length)];
            }

            int versuche = 0;
            boolean gewonnen = false;

            while (versuche < 12) {
                versuche++;
                System.out.println();

                System.out.println("\nVersuch " + versuche + " von 12");

                // Eingabe der Farben
                String[] eingabe = new String[4];
                System.out.print("Gib deine erste Farbe ein: ");
                eingabe[0] = spielregel.nextLine();

                System.out.print("Gib deine zweite Farbe ein: ");
                eingabe[1] = spielregel.nextLine();

                System.out.print("Gib deine dritte Farbe ein: ");
                eingabe[2] = spielregel.nextLine();

                System.out.print("Gib deine vierte Farbe ein: ");
                eingabe[3] = spielregel.nextLine();

                // Vergleich
                int richtigerOrt = 0;
                int richtigeFarbe = 0;
                boolean[] benutztGeheim = new boolean[4];
                boolean[] benutztEingabe = new boolean[4];

                // Richtiger Ort
                for (int i = 0; i < 4; i++) {
                    if (eingabe[i].equals(geheimCode[i])) {
                        richtigerOrt++;
                        benutztGeheim[i] = true;
                        benutztEingabe[i] = true;
                    }
                }

                // Richtige Farbe an falscher Stelle
                for (int i = 0; i < 4; i++) {
                    if (!benutztEingabe[i]) {
                        for (int j = 0; j < 4; j++) {
                            if (!benutztGeheim[j] && eingabe[i].equals(geheimCode[j])) {
                                richtigeFarbe++;
                                benutztGeheim[j] = true;
                                break;
                            }
                        }
                    }
                }


                if (richtigerOrt == 4) {
                    System.out.println(" Glückwunsch! Du hast gewonnen");
                    gewonnen = true;
                    break;
                } else {
                    System.out.println("Richtige Farben am richtigen Ort: " + richtigerOrt);
                    System.out.println("Richtige Farben am falschen Ort: " + richtigeFarbe);
                }

                // Nach jeder dritten Runde, Ausgabe der Farben
                if (versuche % 3 == 0 ) {
                    if (!(versuche == 12)) {
                        System.out.println("\n#################################################################");
                    System.out.println("Farben: Rot, Blau, Grün, Gelb, Pink, Schwarz, Grau und Orange");
                    System.out.println("#################################################################");
                    }
                }

            }


            if (!gewonnen) {
                System.out.println("Leider verloren");
            }

            System.out.print("Möchtest du noch eine Runde spielen? (r = ja / b = beenden): ");
            String antwort = spielregel.nextLine();
            if (!antwort.equals("r")) {
                weiterspielen = false;
            }
        }
    }
}
