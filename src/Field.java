public class Field {
    //todo: information hiding

    int cost;
    int income;
    String label;
    int id;

    public Field(int id, String label, int cost, int income){
        this.cost = cost;
        this.label = label;
        this.income = income;
        this.id = id;
    }

    //fx. "Du er landet på x"

    public String onLand(){
        String message = "Du er landet på "+label;
        return message;
    }

    //Er der blevet sagt ja eller nej
    public void processResponse(){
    }

    @Override
    public String toString(){
        return id+": "+label;
    }
}