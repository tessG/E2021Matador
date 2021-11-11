public class Property extends Field{
    //todo: information hiding
    private Player owner;
    private int seriesID;
    public String currentOption;

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
               s+="Vil du bygge?";
               currentOption = "build";
            }else{
                s+="Du skal betale husleje til "+this.owner;
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

          //sætte this.owner til spiller
           System.out.println("Du er nu ejer af " + label);
           Main.currentPlayer.account.doTransaction(-this.cost);
           this.owner = Main.currentPlayer;



      } else if (currentOption.equals("pay")){

          System.out.println("Du har nu betalt " + this.income+ "i husleje");
          Main.currentPlayer.account.doTransaction(-this.income);
          this.owner.account.doTransaction(this.income);


      }

      //todo: fang når currentOption er "pay". Sørg for at huslejen (gemt i feltets income attribut) bliver trukket fra spillerens konto og sat ind på ejerens konto
        // todo: test


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