import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Reception {
    protected List<Owner> existingCostumers=new ArrayList<>();
    protected List<Owner> petsInToday=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    protected String answerY ="y";
    protected String answerN="n";

    public void fakeClient() {
        Owner owner1 = new Owner("Anna", "0701234567");
        owner1.addPet(new Cat("Misse", "12"));
        Owner owner2 = new Owner("Lars", "0712345678");
        owner2.addPet(new Dog("Rex", "12"));
        existingCostumers.add(owner1);
        existingCostumers.add(owner2);
    }

    public void checkIfCostumer(String number){
        for (Owner costumer : existingCostumers) {
            if (costumer.getPhoneNumber().equalsIgnoreCase(number)){
                if (!petsInToday.contains(costumer)){
                    petsInToday.add(costumer);
                    System.out.println(costumer.getPet().size()+" djur incheckade för dig " + costumer );
                }else {
                    System.out.println("Redan incheckad för idag");
                }
                return;
            }else {
                System.out.println("Hittar ej meddelande, kanske fel nummer?");
            }
        }
    }
    public void addNewCostumer(){
        System.out.println("Lägga till nytt djur, absolut!");
        System.out.println("Vi behöver ditt namn");
        String name=sc.nextLine().trim();
        System.out.println("Vi behöver ditt telefonnummer");
        String number=sc.nextLine().trim();
        if (checkIfOwnerAlreadyHasAnimals(name, number)){
            //existingCostumers.add(new Owner(name, number));
            System.out.println("Du verkar ha ett djur inne, vill du ha ett till på dagis?");
            if (sc.nextLine().equalsIgnoreCase(answerY)){
                //skriva kod som man kan lägga till nya djur till befintlig kund
            }//else att bara avsluta.
        }
    }

    public boolean checkIfOwnerAlreadyHasAnimals(String name, String number){
        for (Owner existingOwner : existingCostumers) {
            if ((existingOwner.getName().equalsIgnoreCase(name))&&(existingOwner.getPhoneNumber().equalsIgnoreCase(number))){
                return true;
            }
        }
        return false;
    }

    public void takeHomeYourAnimal(String phoneNumber){
        for (Owner petOwner : petsInToday) {
            if (petOwner.getPhoneNumber().equalsIgnoreCase(phoneNumber.trim())){
                petsInToday.remove(petOwner);

            }
        }

    }


}