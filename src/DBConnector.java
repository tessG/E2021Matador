import java.sql.*;
import java.util.ArrayList;

    public class DBConnector {

        // database URL
        static final String DB_URL = "jdbc:mysql://localhost/Matador";

        //  Database credentials
        static final String USER = "root";
        static final String PASS = "testdat1";


        public String[] readFieldData() {
            String[] field_data = new String[40];
            Connection conn = null;
            Statement stmt = null;
            try {
                //STEP 2: Register JDBC driver
                // Class.forName("com.mysql.jdbc.Driver");

                //STEP 3: Open a connection
                System.out.println("Connecting to database...");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);

                //STEP 4: Execute a query
                System.out.println("Creating statement...");
                stmt = conn.createStatement();

                String sql = "SELECT * FROM Field";
                ResultSet rs = stmt.executeQuery(sql);

                //STEP 5: Extract data from result set
                while (rs.next()) {
                    //Retrieve by column name
                    int id = rs.getInt("id");
                    String field_type = rs.getString("field_type");
                    String label = rs.getString("label");
                    int cost = rs.getInt("cost");
                    int income = rs.getInt("income");
                    int seriesID = rs.getInt("series_id");
                    field_data[id - 1] = id + "," + field_type + "," + label + "," + cost + "," + income + "," + seriesID;
                }
                //STEP 6: Clean-up environment
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            } catch (Exception e) {
                //Handle errors for Class.forName
                e.printStackTrace();
            } finally {
                //finally block used to close resources
                try {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException se2) {
                }// nothing we can do
                try {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }//end finally try
            }//end try
            return field_data;
        }

        public ArrayList<Player> readGameData() {
            ArrayList<Player> playerList = new ArrayList<>();
            Connection conn = null;
            Statement stmt = null;
            try {
                //STEP 1: Open a connection
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                //STEP 2: Create a statement
                stmt = conn.createStatement();

//STEP 3: Execute a query
                String sql = "SELECT * FROM Player";
                ResultSet rs = stmt.executeQuery(sql);

                //STEP 4: Extract data from result set
                while (rs.next()) {
                    //Retrieve by column name
                    int id = rs.getInt("id");

//todo: træk værdier fra de øvrige kolonner ud




//todo: indkommenter når parametrene er blevet initialiseret

                    // Player p = new Player(name, balance, position, isNext);//using overloaded constructor
                    // playerList.add(p);

                }
                //STEP 6: Clean-up environment
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            } finally {
                //finally block used to close resources
                try {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException se2) {
                }// nothing we can do
                try {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }//end finally try
            }//end try

            return playerList;
        }
    }