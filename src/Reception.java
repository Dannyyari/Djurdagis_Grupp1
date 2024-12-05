import java.util.ArrayList;
import java.util.List;
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
        for (Owner costumer : existingCostumers) {
            if (costumer.getPhoneNumber().equalsIgnoreCase(number)) {
                if (!petsInToday.contains(costumer)) {
                    petsInToday.add(costumer);
                    System.out.println(costumer.getPet().size() + " djur incheckade för dig " + costumer);
                } else {
                    System.out.println("Redan incheckad för idag");
                }
                break;
            }
        }
    }

    public Owner addNewCostumer() {
        System.out.println("Ditt namn");
        String name = sc.nextLine().trim();

        System.out.println("Ditt telefonnummer");
        String number = sc.nextLine().trim();

        Owner newOwner = new Owner(name, number);
        //Kan man lägga till addAnimalToNewOwener här bara och ha (Owner newowner) som inparameter i metoden nedan?
        existingCostumers.add(newOwner);
        return newOwner;
        //Kanske lägga till denna newOnwer i våran lista av befintliga kunder inne i metoden?
    }

    //Kan man använda denna metod för att kunna lägga till nytt djur till befintlig och ny kund?
    //kolla rad 103
    public void addAnimalToNewCustomer() {
        Owner newOwner = addNewCostumer();
        addAnimalToExistingOwner(newOwner.getName(), newOwner.getPhoneNumber());
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

    //Ska det inte vara en inparameter vad de är för djur typ (String nyttDjur)
    //Sedan så har vi inuti denna metod en IF sats typ if nyttDjur==Katt så lägger vi new Animal new Cat(PetName, Pet Age)
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

    public void changePetOwnership(String phoneNumber) {
        Animal pet = null;

        Owner oldOwner = checkIfOwner(phoneNumber);
        if (oldOwner == null) {
            return;
        }

        if (oldOwner.getPet() == null || oldOwner.getPet().isEmpty()) {
            System.out.println("Den här ägaren har inga husdjur");
            return;
        }

        System.out.println("Skapa ny djurägare: ");
        Owner newOwner = addNewCostumer();

        if (oldOwner.getPet().size() > 1) {
            while (pet == null) {
                System.out.println("Vilket husdjur ska byta ägare?: ");
                for (Animal animal : oldOwner.getPet()) {
                    System.out.println(animal.getName());
                }
                String whatPet = sc.nextLine();
                pet = findPetByName(oldOwner, whatPet);
                if (pet == null) {
                    System.out.println("Husdjuret finns inte. Försök igen: ");
                }
            }
        } else {
            pet = oldOwner.getPet().get(0);
        }

        oldOwner.getPet().remove(pet);
        newOwner.getPet().add(pet);

        if (oldOwner.getPet() == null || oldOwner.getPet().isEmpty()) {
            existingCostumers.remove(oldOwner);
        }

        System.out.println("Djuret har bytt ägare");
    }

    private Animal findPetByName(Owner owner, String petName) {
        for (Animal animal : owner.getPet()) {
            if (animal.getName().equalsIgnoreCase(petName)) {
                return animal;
            }
        }
        return null;
    }

    private Owner checkIfOwner(String phoneNumber) {
        for (Owner petOwner : existingCostumers) {
            if (petOwner.getPhoneNumber().equals(phoneNumber)) {
                return petOwner;
            }
        }
        System.out.println("Det finns ingen ägare med det här telefonummret");
        return null;
    }
}

