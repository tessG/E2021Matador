import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   // static BankAccount[] accounts = new BankAccount[3];
   //static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
   static ArrayList<Player> players = new ArrayList<Player>();
   static int MAX = 6;

    public static void main(String [] arg){
        //todo: sørg for at der startes en dialog hvis der ikke er noget game data (demonstration af throws på readGame data, indpakke kald i try-catch, i catch startes dialogen)
        try {
            readGameData();
        }catch(FileNotFoundException e){
            /**
             * Instantiering af et UI objekt hvorpå vi kan igangsætte dialoger med brugeren
             */
            System.out.println(e.getMessage());
             UI ui = new UI();
             ui.createAccounts();
            // ui.manageAccount();
        }

        saveGameData();
        printAccounts();



    }

    private static void saveGameData() {
        String gamedata = "";

        for (Player a : players) {
            gamedata += a;
        }

        try {
            FileWriter writer = new FileWriter("src/data.txt");
            writer.write(gamedata);
            writer.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static void printAccounts() {
        for(Player a: players){
            System.out.println(a);
        }
    }

    /**
     * Indlæser konto data og danner konto objekter på baggrund heraf
     * objekterne gemmes herefter i denne klasses ArrayList<BankAccount>
     *  TODO: tilføj throws FileNotFoundException til metodesignaturen da vi hellere vil fange fejl oppe i main
     *   Hvis der er fejl i læsnign af filen vil vi igangsætte en dialog til manuel indtastning derfra
     */
    private static void readGameData() throws FileNotFoundException{
        File file = new File("src/data.txt");
        Scanner scan = null;

        scan = new Scanner(file);

        while(scan.hasNextLine()){
            String [] values = scan.nextLine().split(":");
            float converted_float = Float.parseFloat(values[1]);
            Player p = new Player(values[0], converted_float);
            players.add(p);
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

















/**
 * Denne metode gemmer sessionens tilstand, dvs listen af konti i formen ejernavn:saldo
 * instantier en gamedata string til
 * loop igennem accounts, og for hver linie tilføj data i formen "ejer:balance" til strengen
 * instantier FileWriter
 */
  /*  public static void saveGameData(){
        String gamedata = "";
        for (BankAccount a:accounts) {
            gamedata = gamedata + a.getOwner()+":"+a.getBalance()+"\n";
        }
        try{
            FileWriter writer = new FileWriter("src/_data.txt");
            writer.write(gamedata);
            writer.close();
            System.out.println("wrote game data to file");
        }catch (IOException e){
            System.out.println(e.getCause());
        }
    }*/