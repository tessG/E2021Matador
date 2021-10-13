import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   static ArrayList<Player> players = new ArrayList();
   static int MAX = 6;

    public static void main(String [] arg){

        UI ui = new UI();

        //Få noget spiller data ind
        try {
            readGameData();
        }catch(FileNotFoundException e){

            System.out.println(e.getMessage());
             ui.createAccounts();
            // ui.manageAccount();
        }
        printAccounts();

        //Byg spillepladen
        Board board = new Board();

        //todo: call gameloop(w. while)
        // - in each loop run use case TakeTurn on behalf of currentPlayer
        // After each turn, ask if player wants to continue or end game




        saveGameData();


    }

    /**
     *
     * Denne metode gemmer sessionens tilstand,
     * instantier en gamedata tekst-streng (String)
     * loop igennem accounts, og for hver linie tilføj data i formen "ejer:balance" til strengen
     * instantier FileWriter og kald dens write med den opbyggede streng som argument
     *
     */

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
     * Indlæser gamedata og danner spillerinstanser på baggrund af data
     * objekterne gemmes herefter i denne klasses ArrayList<Players>
     *
     *   'throws FileNotFoundException' i metodesignaturen fordi vi hellere vil fange indlæsningsfejl oppe i main
     *   - i de tilfælde kan vi i stedet igangsætte en dialog til manuel indtastning af spiller data
     */
    private static void readGameData() throws FileNotFoundException{
        File file = new File("src/data.txt");
        Scanner scan = null;

        scan = new Scanner(file);

        while(scan.hasNextLine()){
            String [] values = scan.nextLine().split(":");
            int converted_int = Integer.parseInt(values[1]);
            Player p = new Player(values[0], converted_int);
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
















