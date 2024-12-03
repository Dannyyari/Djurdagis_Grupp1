public class Dog extends Animal{
    protected final String food= "Torrfoder";
    protected final String medication="Salva";

    public Dog(String name, String age) {
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
        return "Vov!";
    }
}
