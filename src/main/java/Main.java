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
//                    Menu.printProducts();
                    break;
                case 4:
//                    Menu.removeTree();
                    break;
                case 5:
//                    Menu.removeFlower();
                    break;
                case 6:
//                    Menu.removeDeco();
                    break;
                case 7:
//                    Menu.printStock();
                    break;
                case 8:
//                    Menu.printTotalValue();
                    break;
                case 9:
//                    Menu.createTicket();
                    break;
                case 10:
//                    Menu.printAllTickets();
                    break;
                case 11:
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
                    4. Retirar un arbre
                    5. Retirar una flor
                    6. Retirar decoració
                    7. Veure stock de la floristeria
                    8. Veure el valor total de la floristeria
                    9. Crear un ticket de compra
                    10. Vuere el històric de compres
                    11. Vuere el total de vendes
                    0. Sortir de l'aplicació
                    """);

        return User.readIntegerMenu("Introdueix una opció [0-11]: ");


    }
}
