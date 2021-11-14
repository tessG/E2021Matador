public class Player {
    String name;
    int id;
    int position;
    BankAccount account;
    static int counter;

    public Player(String name,int balance){
        this.name = name;
        counter++;
        this.id=counter;
        this.account = new BankAccount(balance);
    }
    //OVERLOADING
    public Player(String name, int balance, int position, boolean isNext) {
        this.name = name;
        this.id = counter;
        this.position = position;
        this.account = new BankAccount(balance);
        if(isNext){
            Main.setTurnCounter(this.id);
        }
        counter++;
    }

    private void pay(int amount) {

        boolean succesfull = account.doTransaction(-amount);
        //todo register amount on Banks own account
        if(!succesfull){
            //Main.roundCount--;
          //  Main.removePlayer(this);
        }
    }
    public void payTax(int cost){
        pay(cost);
    }
    //Overloading
    public int payTax(){
        int amount = Main.currentPlayer.getWorth()/10;
        pay(amount);
        return amount;
    }

    /*
     * Beregner trykte værdi af skøder (også pantsatte)+ 10% af saldo
     *  todo: also calculate worth of buildings
     * */
    public int getWorth(){
        int worth = this.account.getBalance();
      /*  for (Field d:deeds) {
            worth +=d.getCost();
        }*/

        return worth;
    }

    public int updatePosition(int diceRoll){
        position += diceRoll;
        return position;
    }

    @Override
    public String toString(){
        String s;
        s = name +":"+account.getBalance()+"\n";
        return s;
    }

    public String getName() {
        return name;
    }
}
