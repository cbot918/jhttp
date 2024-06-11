package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import redis.clients.jedis.Jedis;

public class Main{
    public static String url = "jdbc:postgresql://localhost:5432/java";
    public static String user = "yale";
    public static String password = "12345";

    public static String query = "";
    public static void main(String[] args){

        Jedis jedis = new Jedis("localhost",6379);
        jedis.set("jkey", "jvalue");
        jedis.close();

        // try(Connection conn = DriverManager.getConnection(url, user, password);
        //     Statement stmt = conn.createStatement()){
            
        //     // Create a new table
        //     String createTableSQL = "CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL)";
        //     stmt.execute(createTableSQL);

        //     query = "insert into users(name) values('yale')";
        //     stmt.execute(query);
            
            
            

        // } catch(Exception e){
        //     e.printStackTrace();
        //     return;
        // }

        System.out.println("process end");
        
    }
}