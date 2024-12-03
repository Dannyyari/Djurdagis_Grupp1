import java.util.ArrayList;
import java.util.List;

public class Owner {
    protected String name;
    protected String phoneNumber;
    protected List<Animal> pet;

    public Owner(String name, String phoneNumber, List<Animal> pet) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.pet = new ArrayList<>();
    }

    public void addPet(Animal petToAd) {
        pet.add(petToAd);
    }

    public void listPets(){
        for (Animal animal : pet) {
            System.out.println(animal.getName() + " kommer nu! " + animal.makeSound());
        }
    }
}
