import java.util.Scanner;

public class UI {

    /**
     * Starter en dialog med brugeren så denne kan oprette op til 6(MAX) konti
     * todo: kod denne om sådan at man kan slippe ud af loopet selvom der kun er 3 deltagere
     * pseudo kode:
     *  tilføj quit mulighed i besked til brugeren
     *  før konstruktor kald, tjek om denne blev valgt
     *  break hvis det er tilfældet
     */
    public void createAccounts() {

        int i = 0;
        while(i<Main.MAX ){
            String input = getUserInput("Navn? (eller Q for at quitte) ");
            if(input.equalsIgnoreCase("Q")){
               break;
            }

            Main.players.add(new Player(input, 30000));
            i++;
        }
    }

    /**
     * Denne metode kan kaldes hver gang man have noget data ud af brugeren
     * @param msg
     * @return returnerer det input brugeren skriver i consollen
     */
    public String getUserInput(String msg){
        System.out.println(msg);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }

    public String startDialog(String msg){
        String input = getUserInput(msg);

        if(!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n" )){
            System.out.println("ugyldigt input");
            startDialog(msg);
        }
        return input;
    }
   /* public void manageAccount() {
        String input = getUserInput("Hvilken konto? :");
        int input_number = Integer.parseInt(input);
        BankAccount account = Main.players.get(input_number);
        input = getUserInput("Beløb? :");
        try{
            float converted_input = Float.parseFloat(input);
            account.doTransaction(converted_input);
        }catch(NumberFormatException e){
            System.out.println("Det var ikke et tal");
        }
    }*/
}
