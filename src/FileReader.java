import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileReader implements IO {
    /**
     * Indlæser gamedata og danner spillerinstanser på baggrund af data
     * objekterne gemmes herefter i denne klasses ArrayList<Players>
     *
     *   'throws FileNotFoundException' i metodesignaturen fordi vi hellere vil fange indlæsningsfejl oppe i main
     *   - i de tilfælde kan vi i stedet igangsætte en dialog til manuel indtastning af spiller data
     */
    //todo: refactor sådan at metoden returnerer en arrayListe af spillere: ArrayList<Player>
    // kald til metoden: players = io.readGameData()
    public ArrayList<Player> readGameData()  {
        ArrayList<Player> players  = new ArrayList<>();
        File file = new File("src/data.txt");
        Scanner scan = null;

        try {
            scan = new Scanner(file);
            scan.nextLine();
            while(scan.hasNextLine()){
                String [] values = scan.nextLine().split(",");
                int balance = Integer.parseInt(values[1]);
                int position = Integer.parseInt(values[2]);
                boolean isNext = Boolean.getBoolean(values[3]);
                Player p = new Player(values[0], balance, position, isNext);
                players.add(p);
            }
        }catch(FileNotFoundException e){
          //  Main.ui.createAccounts();
        }catch (NoSuchElementException e){
            System.out.println("file is empty");
          //  Main.ui.createAccounts();
        }


        return players;
    }

    /**
     *
     * Denne metode gemmer sessionens tilstand,
     * instantier en gamedata tekst-streng (String)
     * loop igennem accounts, og for hver linie tilføj data i formen "ejer:balance" til strengen
     * instantier FileWriter og kald dens write med den opbyggede streng som argument
     *
     */

    public void saveGameData(ArrayList<Player> players) {
        String gamedata = "";
        gamedata="name, balance, position, isNext \n";
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

    @Override
    public String[] readFieldData() {
        String[] data = new String[40];
        File file = new File("src/fields.txt");
        String s;
        int i = 0;
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();//ignorerer headeren

            while(scan.hasNextLine()){
                 s = scan.nextLine();
                 data[i] = s;
                 i++;
            }

        }catch(FileNotFoundException e){
            System.out.println(e.getCause());
        }
        return data;
    }




}
