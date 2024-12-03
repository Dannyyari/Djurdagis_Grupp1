public class Cat extends Animal{
    protected final String food= "Meat";
    protected final String medication= "Antibiotic";

    public Cat(String name, String age) {
        super(name, age);
    }

    public String getFood() {
        return food;
    }

    public String getMedication() {
        return medication;
    }

    @Override
    public String makeSound() {
        return "Mjau";
    }
}
