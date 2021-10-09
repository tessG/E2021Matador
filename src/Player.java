public class Player {
    private int id = 0;
    private static int counter = 0;
    private String name;

    public Player(String name, float balance){
        this.name = name;
        BankAccount account = new BankAccount(name, balance);
        counter++;
        this.id = counter;
    }

    @Override
    public String toString() {
        return "Player{" +name+
                "id=" + id +
                '}';
    }
}

