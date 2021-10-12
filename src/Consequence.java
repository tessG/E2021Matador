public class Consequence extends Field {


    public Consequence(int id, String label, int cost, int income) {
        super(id, label, cost, income);
    }
    //todo: information hiding
    public void onAccept(){
    }

    public void onReject(){
    }

    @Override
    public String toString() {
        String s = super.toString();
        s+=" CONSEQUENCE";
        return s;
    }
}
