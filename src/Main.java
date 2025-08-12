import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

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

            gewonnen = spiel(farben, versuche, geheimCode, false);

            ende(gewonnen, weiterspielen, geheimCode);
        }
    }


    static void spielregeln() {
        System.out.println("Kennst du die Regeln für das Spiel MasterMind? Antworte mit Ja oder Nein!");
        String kenntRegeln = scanner.nextLine().toLowerCase();

        if (kenntRegeln.equals("ja")) {
            System.out.println("Die möglichen Farben sind: Rot, Blau, Grün, Gelb, Pink, Schwarz, Grau und Orange");
        }

        if (kenntRegeln.equals("nein")) {
            System.out.println("Spielregeln:\n" +
                    "Es gibt eine versteckte Farbenfolge, die aus vier Farben besteht\n" +
                    "Dabei dürfen die Farben doppelt vorkommen\n" +
                    "Farben: Rot, Blau, Grün, Gelb, Pink, Schwarz, Grau und Orange\n" +
                    "Du gibst nacheinander vier Farben ein\n" +
                    "Maximal 12 Versuche");
        }

        if (!(kenntRegeln.equals("ja") || kenntRegeln.equals("nein"))) {
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


    static boolean spiel(String[] farben, int versuche, String[] geheimCode, boolean gewonnen) {
        while (versuche < 12) {
            versuche++;
            System.out.println();

            System.out.println("\nVersuch " + versuche + " von 12");

            String[] eingabe = new String[4];

            for (int i = 0; i < 4; i++) {
                boolean richtigefarbe = false;
                while (!richtigefarbe) {
                    System.out.print("Gib die " + (i + 1) + ". Farbe ein: ");
                    String userInput = scanner.nextLine().toLowerCase().trim().replaceAll(" ", "");
                    for (String f : farben) {
                        if (f.equals(userInput)) {
                            eingabe[i] = userInput;
                            richtigefarbe = true;
                            break;
                        }
                    }
                    if (!richtigefarbe) {
                        System.out.println("Diese Farbe gibt es nicht. Erlaubt: " + String.join(", ", farben));
                    }
                }
            }

            //Elio

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
                System.out.println("\n#################################################################");
                System.out.println(" Glückwunsch! Du hast gewonnen");
                return true;
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
        return false;
    }


    static boolean ende (boolean gewonnen, boolean weiterspielen, String [] geheimCode) {
        if (!gewonnen) {
            System.out.println("\n#################################################################");
            System.out.println("Leider verloren! Der Code wäre gewesen: " + Arrays.toString(geheimCode) + ".");

        }

        System.out.println("#################################################################");
        System.out.print("Möchtest du noch eine Runde spielen? (r = ja / b = beenden): ");
        String antwort = scanner.nextLine();

        while (!antwort.equals("r") && !antwort.equals("b")) {
            System.out.println("r oder b");
            antwort = scanner.nextLine();
        }

        if (antwort.equals("b")) {
            System.out.println("Spiel wird beendet...");
            System.exit(0);
        }
        if (antwort.equals("r")) {
            System.out.println("\n#################################################################");
            System.out.println("Farben: Rot, Blau, Grün, Gelb, Pink, Schwarz, Grau und Orange");
            System.out.println("#################################################################");
            return true;
        }
        return false;
    }
}