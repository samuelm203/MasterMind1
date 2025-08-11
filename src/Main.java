import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner spielregel = new Scanner(System.in);

    public static void main(String[] args) {
        Random generator = new Random();

        spielregeln();

        String[] geheimCode = new String[4];
        String[] farben = {
                "rot", "blau", "grün", "gelb", "pink", "schwarz", "grau", "orange"
        };

        boolean weiterspielen = true;

        while (weiterspielen) {

            farbfolge(farben, geheimCode);

            int versuche = 0;
            boolean gewonnen = false;

            spiel(farben, versuche, geheimCode, gewonnen);

            ende(gewonnen, weiterspielen, geheimCode);
        }
    }



    static void spielregeln() {
        System.out.println("Kennst du die Regeln für das Spiel MasterMind? Antworte mit Ja oder Nein!");
        String entscheidung1 = spielregel.nextLine().toLowerCase();

        if (entscheidung1.equals("ja")) {
            System.out.println("Die möglichen Farben sind: Rot, Blau, Grün, Gelb, Pink, Schwarz, Grau und Orange");
        }

        if (entscheidung1.equals("nein")) {
            System.out.println("Spielregeln:\n" +
                    "Es gibt eine versteckte Farbenfolge, die aus vier Farben besteht\n" +
                    "Dabei dürfen die Farben doppelt vorkommen\n" +
                    "Farben: Rot, Blau, Grün, Gelb, Pink, Schwarz, Grau und Orange\n" +
                    "Du gibst nacheinander vier Farben ein\n" +
                    "Maximal 12 Versuche");
        }

        if (!(entscheidung1.equals("ja") || entscheidung1.equals("nein"))) {
            System.out.println("Bro, es isch gstande ja oder nein :(");
            System.exit(0);
        }


    }

    static void farbfolge(String[] farben, String[] geheimCode) {
        Random generator = new Random();
        for (int i = 0; i < 4; i++) {
            geheimCode[i] = farben[generator.nextInt(farben.length)];
        }
    }

    static void spiel(String [] farben, int versuche, String [] geheimCode, boolean gewonnen) {
        while (versuche < 12) {
            versuche++;
            System.out.println();

            System.out.println("\nVersuch " + versuche + " von 12");

            String[] eingabe = new String[4];

            for (int i = 0; i < 4; i++) {
                boolean richtigefarbe = false;
                while (!richtigefarbe) {
                    System.out.print("Gib die " + (i+1) + ". Farbe ein: ");
                    String userInput = spielregel.nextLine().toLowerCase().trim().replaceAll(" ", "");
                    for (String f : farben) {
                        if (f.equals(userInput)) {
                            eingabe[i] = userInput;
                            richtigefarbe = true;
                            break;
                        }
                    }
                    if (!richtigefarbe) {
                        System.out.println("Diese Farbe gibt es nicht . Erlaubt: " + String.join(", ", farben));
                    }
                }
            }


            int richtigerOrt = 0;
            int richtigeFarbe = 0;
            boolean[] benutztGeheim = new boolean[4];
            boolean[] benutztEingabe = new boolean[4];

            for (int i = 0; i < 4; i++) {
                if (eingabe[i].equals(geheimCode[i])) {
                    richtigerOrt++;
                    benutztGeheim[i] = true;
                    benutztEingabe[i] = true;
                }
            }

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
                break;  // Beende die Schleife, wenn gewonnen
            } else {
                System.out.println("Richtige Farben am richtigen Ort: " + richtigerOrt);
                System.out.println("Richtige Farben am falschen Ort: " + richtigeFarbe);
            }

            if (versuche % 3 == 0) {
                if (!(versuche == 12)) {
                    System.out.println("\n#################################################################");
                    System.out.println("Farben: Rot, Blau, Grün, Gelb, Pink, Schwarz, Grau und Orange");
                    System.out.println("#################################################################");
                }
            }
        }
    }
    static void ende (boolean gewonnen, boolean weiterspielen, String [] geheimCode) {
        if (!gewonnen) {
            System.out.println("\n#################################################################");
            System.out.println("Leider verloren! Der Code wäre gewesen: " + geheimCode + ".");
        }


        System.out.print("Möchtest du noch eine Runde spielen? (r = ja / b = beenden): ");
        String antwort = spielregel.nextLine();
        System.out.println("#################################################################");
        if (!antwort.equals("r")) {
            weiterspielen = false;
        }
    }
}