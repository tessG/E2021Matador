public class Consequence extends Field {


    public Consequence(int id, String label, int cost, int income) {
        super(id, label, cost, income);
    }
    //todo: information hiding
    @Override
    public String onLand(){
        currentOption = null;
        String msg= super.onLand();
        return msg+ "Træk et kort (endnu ikke implementeret). Tast Y";
    }


    @Override
    protected String onAccept() {
       return "kort trukket (endnu ikke implementeret)";
    }

    @Override
    protected String onReject() {
        return null;
    }

}
