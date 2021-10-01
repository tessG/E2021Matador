import java.util.Scanner;

public class UI {

    static int MAX = 6;

    /**
     * Starter en dialog med brugeren så denne kan oprette op til 6(MAX) konti
     */
    public void createAccounts() {
        String choice;
        int i = 0;
        while(i<MAX){
            String name = getUserInput("Navn? : ");
            Main.accounts.add(new BankAccount(name,30000));
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


    public void manageAccount() {
        String input = getUserInput("Hvilken konto? :");
        int input_number = Integer.parseInt(input);
        BankAccount account = Main.accounts.get(input_number);
        input = getUserInput("Beløb? :");
        try{
            float converted_input = Float.parseFloat(input);
            account.doTransaction(converted_input);
        }catch(NumberFormatException e){
            System.out.println("Det var ikke et tal");
        }
    }
}
