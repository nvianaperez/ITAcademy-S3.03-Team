package Entities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class User {

    public static int readIntegerMenu(String message) {
        Scanner sc = new Scanner(System.in);
        boolean checked = false;
        int input = 0;
        while (!checked) {
            try {
                System.out.println(message);
                input = sc.nextInt();
                checkRangeInteger(input);
                checked = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: introdueix un número enter");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Error al introduir el número");
                sc.nextLine();
            }
        }
        return input;
    }

    private static void checkRangeInteger(int input) {
        if(input < 0 || input > 9) throw new RuntimeException();
    }

    public static int readInteger(String message) {
        Scanner sc = new Scanner(System.in);
        boolean checked = false;
        int input = 0;
        while (!checked) {
            try {
                System.out.println(message);
                input = sc.nextInt();
                checkPositiveInteger(input);
                checked = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: introdueix un número enter");
                sc.next();
            } catch (Exception e) {
                System.out.println("Error: introdueix un número positiu");
            }
        }
        return input;
    }

    private static void checkPositiveInteger(int input) {
        if(input < 0) throw new RuntimeException();
    }

    public static String readString(String message) {
        Scanner sc = new Scanner(System.in);
        boolean checked = false;
        String input="";
        while (!checked) {
            try{
                System.out.println(message);
                input = sc.nextLine();
                checkCharactersInString(input);
                checkEmptyString(input);
                checked = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: el nom només pot contenir lletres");
            } catch (Exception e) {
                System.out.println("Error: el nom no pot estar buit");
            }
        }
        return input;
    }

    private static void checkEmptyString(String input) throws Exception {
        if(input.isEmpty()) throw new Exception();
    }

    private static void checkCharactersInString(String input) {
        if(!input.matches("[a-zA-Z]+")) throw new InputMismatchException();
    }

    public static float readFloat(String message) {
        Scanner sc = new Scanner(System.in);
        boolean checked = false;
        float input = 0.0f;
        while (!checked) {
            try{
                System.out.println(message);
                input = sc.nextFloat();
                checked=true;
            }catch(InputMismatchException e){
                System.out.println("Error: introdueix un número float (amb coma i decimals)");
                sc.next();
            }
        }
        return input;
    }

}
