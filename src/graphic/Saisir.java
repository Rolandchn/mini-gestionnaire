package graphic;

import java.util.Scanner;


public class Saisir{
    private Scanner sc;

    public Saisir(Scanner sc){
        this.sc = sc;
    }

    public int saisirInt(String message, String messageErreur){
        int input;

        while(true){
            System.out.println(message);
            System.out.print(">");

            // ça vérifie si l'utilisateur a bien écrit un nombre
            try {
                input = Integer.parseInt(sc.nextLine().trim());
                break;
    
            } catch (NumberFormatException e) {
                System.out.println(messageErreur);
            }
        }

        return input;
    }

    public char saisirChar(String message, String messageErreur){
        String input;

        while(true){
            System.out.println(message);
            System.out.print(">");
            input = sc.nextLine();

            // ça vérifie si l'utilisateur a bien écrit une lettre
            if(input.length() != 1 || !Character.isLetter(input.charAt(0))){
                System.out.println(messageErreur);
                continue;
            }
            break;
        }

        return input.charAt(0);
    }

    public String saisirString(String message, String messageErreur){
        String input;
        
        while(true){
            System.out.println(message);
            System.out.print(">");
            input = sc.nextLine();

            input = input.trim();
            
            // format = regex (expression régulière). ça vérifie si l'utilisateur a bien écrit l'input.
            if(input.split(" ").length > 1){
                System.out.println(messageErreur);
                continue;
            }
        
            break;
        }

        return input;
    }

    public String [] saisirSuite(String format, String message, String messageErreur){
        String input;
        String [] trim_input;
        
        while(true){
            System.out.println(message);
            System.out.print(">");
            input = sc.nextLine();

            input = input.trim();
            
            // format = regex (expression régulière). ça vérifie si l'utilisateur a bien écrit l'input.
            if(!input.matches(format)){
                System.out.println(messageErreur);
                continue;
            }
        
            // Permet de retirer les espaces inutils (ex input:"B 1   3   2" -> {B, 1, 3, 2})
            trim_input = input.split("\\s+");
        
            break;
        }

        return trim_input;
    }

    // permet de fermer le Scanner
    public void closeSaisir(){
        sc.close();
    }
}