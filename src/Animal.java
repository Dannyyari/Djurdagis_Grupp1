public class Animal implements Interface {
    protected String name;
    protected String age;

    public Animal(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Animal() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name: " + name +
                " age: " + age +
                '\'';
    }

    @Override
    public String makeSound() {
        return "";
    }
}
