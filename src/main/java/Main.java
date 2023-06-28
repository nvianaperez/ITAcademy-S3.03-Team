import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }
    //ToDo: preguntar a Romina cómo recoger el atributo name de la tienda, en el constructor, en el setter o en el momento de instanciar el objeto
    //ToDo: ¿es útil un User Singleton?

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
//                    Menu.createTicket();
                    break;
                case 12:
//                    Menu.printAllTickets();
                    break;
                case 13:
//                    Menu.printTotalTickets();
                    break;
                default:
                    System.out.println("Error: introdueix una opció");
                case 0:
                    System.out.println("Gràcies per la teva visita");
                    exit = true;

            }
        }
    }

    private static int showMenu(Scanner sc) {
        System.out.println("""
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

        return User.readIntegerMenu("Introdueix una opció [0-13]: ", sc);

    }
}
