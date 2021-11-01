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
        this.account = new BankAccount(name,balance);
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

}
