public class Bird extends Animal {
    protected final String food= "Solrosfrön";
    protected final String medication="Vitaminer";

    public Bird(String name, String age) {
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
        return "Chyrp Chyrp";
    }
}
