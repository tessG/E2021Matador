public class Board {
    Field[] fields = new Field[40];

    public Board(){
        setFields();
    }
    private void setFields(){
        System.out.println("Board.setFields. Dying to set some fields - but I need some data");
        //todo: læse field data ind, instantiere felter af forskellig type
        fields[0] = new Start(1, "Start",0, 4000);
    }
   public Field getField(int position){
        return fields[position-1];
   }
}
