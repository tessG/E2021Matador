public class Tax  extends Consequence{
    public Tax(int id, String label, int cost) {
        super(id, label, cost,0);
    }
    @Override
    public String onLand(){
        //todo: i reglerne står der at man her får muligheden for atvælge om man vil betale et fast beløb eller 10 % af sine samlede værdier.

        String message=" Du kan betale " + this.getCost()+". Hvis du nægter vil der blive trukket 10% af dine samlede værdier. Betal "+this.getCost()+"kr ? Y/N:";
        this.currentOption = "pay";
        return message;
    }



    @Override
    protected String onAccept(){
        if(this.currentOption.equals("pay")){
            Main.currentPlayer.payTax(this.getCost());
        }
        return "";
    }
    protected String onReject(){
        String message="";
        if(this.currentOption.equals("pay")) {
            int amount = Main.currentPlayer.payTax();
            message = Main.currentPlayer.getName()+" vil ikke betale den faste skat på "+this.getCost()
                    +"\nDer vil i stedet blive trukket 10% af "
                    +Main.currentPlayer.getName() +"'s samlede værdier beregnet til: "+amount+"kr.\n";
        }
        return message;
    }


}