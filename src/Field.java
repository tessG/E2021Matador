abstract public class Field {
    //todo: information hiding
    int cost;
    int income;
    String label;
    int id;
    public String currentOption;

    public Field(int id, String label, int cost, int income){
        this.cost = cost;
        this.label = label;
        this.income = income;
        this.id = id;
    }

    //fx. "Du er landet på x"

    public String onLand(){
        String message = "Du er landet på "+label+"\n";
        return message;
    }

    //Er der blevet sagt ja eller nej
    public String processResponse(String response){
       String message="";
        if(response.equalsIgnoreCase("Y")){
            message = this.onAccept();
        }else{
            message = this.onReject();
        }
        return message;
    }

    abstract protected String onAccept();
    abstract protected String onReject();
    @Override
    public String toString(){
        return id+": "+label;
    }
    public int getCost() {
        return cost;
    }
}