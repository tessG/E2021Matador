public class Dice {
    private int die1;
    private int die2;
    private boolean pair;

    public Dice() {
    }

    public int throwDice(){
        die1 = (int) (6*Math.random() + 1);
        die2 = (int) (6*Math.random() + 1);

        if(die1 == die2) pair = true;
        else pair = false;

        return die1+die2;
    }

    public boolean getPair() { return pair;}
}