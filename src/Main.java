package src;

// sql
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

// redis
// import redis.clients.jedis.Jedis;

// kafka
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class Main{
    public static String url = "jdbc:postgresql://localhost:5432/java";
    public static String user = "yale";
    public static String password = "12345";

    public static String query = "";
    public static void main(String[] args){

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        String topic = "test-topic";
        String key = "myKey2";
        String value = "Hello, Kafka2!";
        

        try {
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
            RecordMetadata metadata = producer.send(record).get();
            System.out.printf("Sent record(key=%s value=%s) meta(partition=%d, offset=%d)\n",
                    record.key(), record.value(), metadata.partition(), metadata.offset());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        } 

        // redis
        // Jedis jedis = new Jedis("localhost",6379);
        // jedis.set("jkey", "jvalue");
        // jedis.close();

        // postgres
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