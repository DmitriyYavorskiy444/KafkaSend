import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, SQLException {
        KafkaService kafkaService = new KafkaService();
        DbService db = new DbService();

//        HashMap<String, String> messageTemplate = new HashMap<>();
//        messageTemplate.put("name", "Int[10-30]");
//        messageTemplate.put("age", "String[10-20]");
//        messageTemplate.put("vwucdcivhw", "Array<int>");

        ArrayList<String> rows = db.executeQuery("select row_to_json(columns) from(select * from invoice) as columns limit 5");
//        ArrayList<String> messages = new KafkaMessageGenerator().messageGenerator(5, messageTemplate);

//        kafkaService.sendMessage("topicPretest", "Hello, world!");
//        kafkaService.sendMessageBatch("topicPretest2", messages, 0);
        kafkaService.sendMessageBatch("topicPretestReal", rows, 0);
    }
}