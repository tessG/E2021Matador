public class Property extends Field{
    //todo: information hiding
    private Player owner;
    private int seriesID;
    private String currentOption;

    public Property(int id, String label, int cost, int income, int seriesID) {
        super(id, label, cost, income);
        this.seriesID = seriesID;
    }

    @Override
    public String onLand(){
        String s = super.onLand();
        if(this.owner!=null){
            //todo: tjek om der er monopol
            if(this.owner == Main.currentPlayer){
               s+="Vil du bygge? Tast y";
               currentOption = "build";
            }else{
                s+= "Du skal betale husleje til "+this.owner;
                //todo: sæt timer
                currentOption = "pay";
            }

        }else{
           s+="Vil du købe grunden?";
            currentOption = "buy";
        }
        return s;
    }


    @Override
    public void onAccept(){
      if(currentOption.equals("buy")){
          //Todo: træk penge fra spillerens konto og gi til banken
          //sætte this.owner til spiller
          System.out.println("Du er nu ejer af " + label);

      }
    }



    @Override
    public String toString() {
        String s = super.toString();
        s+=  "En del af serie: "+ seriesID;
        return s;
    }
    public int getSeriesID(){
        return seriesID;
    }
}