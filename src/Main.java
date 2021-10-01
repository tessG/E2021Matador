import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   // static BankAccount[] accounts = new BankAccount[3];
   static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();


    public static void main(String [] arg){



        readGameData();

        /**
         * Her har vi gjort klar til at få data fra brugeren i de tilfælde,
         * hvor der ikke findes noget game data.
         * Instantiering af et UI objekt hvorpå vi kan igangsætte dialoger med brugeren
         */

        /*UI ui = new UI();
        ui.createAccounts();
        ui.manageAccount();*/

        //test
        System.out.println(accounts.get(0));
        System.out.println(accounts.get(1));
        System.out.println(accounts.get(2));
    }

    /**
     * Indlæser konto data og danner konto objekter på baggrund heraf
     * objekterne gemmes herefter i denne klasses ArrayList<BankAccount>
     */
    private static void readGameData() {
        File file = new File("src/data.txt");
        Scanner scan = null;
        try{
            scan = new Scanner(file);
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        while(scan.hasNextLine()){
            String [] values = scan.nextLine().split(":");
            float converted_float = Float.parseFloat(values[1]);
            BankAccount account = new BankAccount(values[0], converted_float);
            accounts.add(account);
        }
    }

    /**
     * Denne metode skal ikke bruges lige nu.
     * Den ender nok inde i UI der har med al brugerinteraktion at gøre
     */
    private static void showMenu() {
        System.out.println("Press Q to quit");
        System.out.println("Press C to create Bank Accounts");
        System.out.println("Press T to do transaction");
    }

}
