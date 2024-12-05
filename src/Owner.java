import java.util.ArrayList;
import java.util.List;

public class Owner {
    protected String name;
    protected String phoneNumber;
    protected List<Animal> pet;

    public Owner(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.pet = new ArrayList<>();
    }

    public void addPet(Animal petToAd) {
        pet.add(petToAd);
    }

    public void callOnPet(){
        for (Animal animal : pet) {
            System.out.println(animal.getName() + " kommer nu! " + animal.makeSound());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Animal> getPet() {
        return pet;
    }

    public void setPet(List<Animal> pet) {
        this.pet = pet;
    }
}
