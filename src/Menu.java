import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    ArrayList<String> validChoices = new ArrayList<>(Arrays.asList("L", "H", "I", "R", "B", "A"));

    public String getUserInputString() {
        while (true) {
            String userInput = scanner.nextLine().toUpperCase();
            if (userInput.isEmpty()) {
                System.out.println("Du måste ange en bokstav. Försök igen: \n");
            } else if (validChoices.contains(userInput)) {
                return userInput;
            } else {
                System.out.println("Valet finns inte. Försök igen: ");
            }
        }
    }

    public void showMenu() {
        System.out.println("Hej! Välkommen till Djurdagis! Vad vill du göra?");
        System.out.println("[L]ämna djur\n" +
                "[H]ämta djur\n" +
                "[I]nformation om djur\n" +
                "[R]egistrera ditt djur\n" +
                "[B]yta ägare\n" +
                "[A]vsluta programmet");
    }

    public boolean menuChoice(String userMenuChoice) {
        switch (userMenuChoice) {
            case "L":
                //Lämna djur
                return true;
            case "H":
                //Hämta djur
                return true;
            case "I":
                //Information om djur
                return true;
            case "R":
                //Registrera djur
                return true;
            case "B":
                //Byta ägare
                return true;
            case "A":
                //avsluta programmet
                System.out.println("Programmet avslutas");
                return false;
            default:
                break;
        }
        return true;
    }

}
