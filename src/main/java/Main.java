import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, SQLException {
        KafkaService kafkaService = new KafkaService();
        DbService db = new DbService();

        HashMap<String, String> messageTemplate = new HashMap<>();
        messageTemplate.put("name", "Int[10-30]");
        messageTemplate.put("age", "String[10-20]");
        messageTemplate.put("vwucdcivhw", "Array<int>");

        ArrayList<String> rows = db.executeQuery("SELECT * FROM invoice limit 10");
        ArrayList<String> messages = new KafkaMessageGenerator().messageGenerator(5, messageTemplate);

        kafkaService.sendMessage("topicPretest", "Hello, world!");
        kafkaService.sendMessageKey("topicPretest", "1d", "testValue");
        kafkaService.sendMessageBatch("topicPretest", rows, 0);
        kafkaService.sendMessageBatch("topicPretest",messages,0);
//                -----------Test of messages-----------
//        db.executeQuery("SELECT * FROM invoice limit 2").forEach(System.out::println);

    }
}



