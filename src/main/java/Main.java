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
                    Menu.addTree();
                    break;
                case 3:
//                    Menu.addFlower();
                    break;
                case 4:
//                    Menu.addDeco();
                    break;
                case 5:
//                    Menu.printProducts();
                    break;
                case 6:
//                    Menu.removeTree();
                    break;
                case 7:
//                    Menu.removeFlower();
                    break;
                case 8:
//                    Menu.removeDeco();
                    break;
                case 9:
//                    Menu.printStock();
                    break;
                case 10:
//                    Menu.printTotalValue();
                    break;
                case 11:
                     Menu.addTicket();
                    break;
                case 12:
//                    Menu.printAllTickets();
                    break;
                case 13:
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
<<<<<<< HEAD
                    ***** MENU *****
                    1. Crear floristeria
                    2. Afegir un arbre
                    3. Afegir una flor
                    4. Afegir decoració
                    5. Veure els tipus de producte de la floristeria
                    6. Retirar un arbre
                    7. Retirar una flor
                    8. Retirar decoració
                    9. Veure stock de la floristeria
                    10. Veure el valor total de la floristeria
                    11. Crear un ticket de compra
                    12. Vuere el històric de compres
                    13. Vuere el total de vendes
                    0. Sortir de l'aplicació
                    """);

        return User.readIntegerMenu("Introdueix una opció [0-13]: ");


    }
}
