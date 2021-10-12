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

    //Vil du købe grunden
    public String createOption(String s){

        return s;
    }

    //Er der blevet sagt ja eller nej
    public void processResponse(){
    }

    @Override
    public String toString(){
        return id+": "+label;
    }
}