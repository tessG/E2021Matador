public class BankAccount{
    private int balance = 30000;

    private int stalkingCounter = 0;

    /**
     * Konstruktor for klassen BankAccount
     *
     */
    public BankAccount(int balance){

       this.balance = balance;
    }

    public boolean doTransaction(int amount){
        if (sufficientFunds(amount)) {
            this.balance += amount; // same as balance = balance+ amount;
            return true;
        }
        //player dies
        return false;
    }

    // Check if player has enough money on their account for the transaction with given amount
    public boolean sufficientFunds(int amount) {
        if (getBalance() + amount < 0) {
            System.out.println("Player does not have enough money");
            return false;
        }
        return true;
    }



    public int getBalance() {
        this.stalkingCounter++;// Den her linje skal demonstrere en af de ting jeg som programmør kan få ud af begrænse adgangen klassens felter (bemærk feltet 'balance' i toppen af klassen er private).
                               // Hver gang instansens balance attribut skal 'ses' udefra, skal det ske gennem denne metode og jeg kan så tilføje lidt  kode der kører hver gang dette sker
                              // I dette eksempel bliver en 'stalkingCounter' talt op. M.a.o.: jeg tracker data om udefrakommende interesse i feltet saldo.
        return balance;
    }


}
