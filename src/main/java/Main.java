import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            int option = showMenu(sc);
            switch (option) {
                case 1:
                    Menu.createStore();
                    break;
                case 2:
                    Menu.addProduct();
                    break;
                case 3:
                    Menu.printProducts();
                    break;
                case 4:
//                    Menu.removeProduct();
                    break;
                case 5:
                    Menu.printStock();
                    break;
                case 6:
                    Menu.printTotalValue();
                    break;
                case 7:
//                    Menu.createTicket();
                    break;
                case 8:
//                    Menu.printAllTickets();
                    break;
                case 9:
//                    Menu.printTotalTickets();
                    break;
                case 0:
                    System.out.println("Gràcies per la teva visita");
                    exit = true;
                    break;
                default:
                    System.out.println("Error: introdueix una opció");
            }
        }
    }

    private static int showMenu(Scanner sc) {
        System.out.println("""
                    ***** MENU *****
                    1. Crear floristeria
                    2. Afegir un producte
                    3. Veure els tipus de producte de la floristeria
                    4. Retirar un producte
                    5. Veure stock de la floristeria
                    6. Veure el valor total de la floristeria
                    7. Crear un ticket de compra
                    8. Vuere el històric de compres
                    9. Vuere el total de vendes
                    0. Sortir de l'aplicació
                    """);

        return User.readIntegerMenu("Introdueix una opció [0-9]: ");


    }
}
