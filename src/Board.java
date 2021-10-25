public class Board {
    Field[] fields = new Field[40];

    public Board(String[] data){
        setFields(data);
    }
    public void setFields(String[] data){
     for (int i = 0; i < data.length; i++) {
        String[] fieldData = data[i].split(",");
        int id = Integer.parseInt(fieldData[0].trim());
        String fieldType = fieldData[1].trim();
        String label = fieldData[2].trim();
        int cost = Integer.parseInt(fieldData[3].trim());
        int income = Integer.parseInt(fieldData[4].trim());
        int seriesID = Integer.parseInt(fieldData[5].trim());

        // Instantiate appropriate type according to fieldType
        Field field = null;

        switch (fieldType) {
            case "Start":
                System.out.println(id);
                field = new Start(id, label, income);
                break;
            case "Land":
                //todo: create Plot class
                field = new Plot(id, label, cost, income,seriesID);
                break;
            case "Brewery":
                field = new Brewery(id, label, cost, income,seriesID);
                break;
            case "ShippingLine":
                field = new ShippingLine(id, label, cost, income,seriesID);
                break;

            case "Chance":
                //todo: create Chance class
                field = new Chance(id, label);
                break;
            case "Tax":
                field = new Tax(id, label, cost);
                break;
            case "Jail":
                //todo: create Jail class
                field = new Jail(id, label, cost);
                break;
            case "Visit":
                //todo: create Visit class
                field = new Consequence(id, label,0,0);
                break;
            case "Parkering":
                //todo: create Bonus (or Parking) class
               // field = new Bonus(id, label,0, cost);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + fieldType);
        }
        fields[id - 1] = field;
    }
}

   public Field getField(int position){
        return fields[position-1];
   }
}
