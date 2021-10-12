public class Property extends Field{
    //todo: information hiding

    private int seriesID;

    public Property(int id, String label, int cost, int income, int seriesID) {
        super(id, label, cost, income);
        this.seriesID = seriesID;
    }

    public void onAccept(){

    }

    public void onReject(){

    }

    @Override
    public String toString() {
        String s = super.toString();
        s+=  "En del af serie: "+ seriesID;
        return s;
    }
}