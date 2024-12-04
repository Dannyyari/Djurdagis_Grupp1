import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Reception {

    protected List<Owner> existingCostumers = new ArrayList<>();
    protected List<Owner> petsInToday = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    protected String answerY = "y";
    protected String answerN = "n";

    public void fakeClient() {
        Owner owner1 = new Owner("Anna", "0701234567");
        owner1.addPet(new Cat("Misse", "12"));

        Owner owner2 = new Owner("Lars", "0712345678");
        owner2.addPet(new Dog("Rex", "12"));
        existingCostumers.add(owner1);
        existingCostumers.add(owner2);
    }

    public void checkIfCostumer(String number) {
        boolean found = false;
        for (Owner costumer : existingCostumers) {
            if (costumer.getPhoneNumber().equalsIgnoreCase(number)) {
                found = true;
                if (!petsInToday.contains(costumer)) {
                    petsInToday.add(costumer);
                    System.out.println(costumer.getPet().size() + " djur incheckade för dig " + costumer);
                } else {
                    System.out.println("Redan incheckad för idag");
                }
                break;
            }
        }
        if (!found)
            System.out.println("Hittar ej, kanske fel nummer?");
    }

    public void addNewCostumer() {
        System.out.println("Lägga till nytt djur, absolut!");

        System.out.println("Ditt namn");
        String name = sc.nextLine().trim();

        System.out.println("Ditt telefonnummer");
        String number = sc.nextLine().trim();

        if (checkIfOwnerAlreadyHasAnimals(name, number)) {
            System.out.println("Du har redan ett djur inlagd, vill du lägga till en till? (y/n)");
            String answer = sc.nextLine().trim();

            if (answer.equalsIgnoreCase(answerY)) {
                System.out.println("Lägger till djur på: " + name);
                addAnimalToExistingOwner(name, number);
            }
            } else {
                Owner newOwner = new Owner(name, number);
                Animal newAnimal = createNewAnimal();
                newOwner.addPet(newAnimal);
                existingCostumers.add(newOwner);
                System.out.println("Ny kund och djur tillagd: " + newOwner);
            }
        }


    public boolean checkIfOwnerAlreadyHasAnimals(String name, String number) {
        for (Owner existingOwner : existingCostumers) {
            if ((existingOwner.getName().equalsIgnoreCase(name)) && (existingOwner.getPhoneNumber().equalsIgnoreCase(number))) {
                return true;
            }
        }
        return false;
    }

    public void takeHomeYourAnimal(String phoneNumber) {
        for (Owner petOwner : petsInToday) {
            if (petOwner.getPhoneNumber().equalsIgnoreCase(phoneNumber.trim())) {
                petsInToday.remove(petOwner);
            }
        }
    }

    public void addAnimal() {

        Animal newAnimal = createNewAnimal();

        System.out.println("Ange ägares mobilnummer:");
        String phonenumber = sc.nextLine().trim();

        for (Owner owner : existingCostumers) {
            if (owner.getPhoneNumber().equalsIgnoreCase(phonenumber)) {
                owner.addPet(newAnimal);
                System.out.println("Djuret är tillagd för " + owner.getName());
                return;
            }
        }
        System.out.println("Ägare hittades ej!");
    }
    private Animal createNewAnimal() {
        System.out.println("Djurets namn:");
        String petName = sc.nextLine().trim();

        System.out.println("Djurets ålder:");
        String petAge = sc.nextLine().trim();

        return new Animal(petName, petAge);
    }

    private void addAnimalToExistingOwner(String name, String number) {
        for (Owner existingOwner : existingCostumers) {
            if (existingOwner.getName().equalsIgnoreCase(name) &&
                    existingOwner.getPhoneNumber().equalsIgnoreCase(number)) {

                Animal newAnimal = createNewAnimal();
                existingOwner.addPet(newAnimal);
                System.out.println("Djuret har lagts till för " + existingOwner.getName());
                return;
            }
        }
        System.out.println("Kunde inte hitta kunden.");
    }

    public void listAnimals() {
        System.out.println("Incheckade djur:");
        for (Owner petOwner : petsInToday) {
            System.out.println("Registrerad ägare: " + petOwner.getName());
            for (Animal animal : petOwner.getPet()) {
                System.out.println("- Namn: " + animal.getName() + ", Ålder: " + animal.getAge());
            }
        }
    }

    public static void main(String[] args) {
        Reception reception = new Reception();
        reception.fakeClient(); // Skapa testkunder
        reception.addAnimal(); // Lägg till ett djur
        reception.listAnimals(); // Lista incheckade djur
    }
}










