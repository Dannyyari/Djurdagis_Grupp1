public class Main {

    private Menu menu;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public Main() {
        this.menu = new Menu();
    }

    public void run() {
        boolean choice  = true;
        while (choice) {
            menu.showMenu();
            choice = menu.menuChoice(menu.getUserInputString());
        }
    }
}
