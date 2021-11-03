import org.json.JSONObject;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, SQLException {
        KafkaService kafkaService = new KafkaService();
        DbService db = new DbService();

//        for (int i = 0; i < 2; i++) {
//            System.out.println("DB: " + db);
//        }
//        for (int i = 0; i < 2; i++) {
//            System.out.println("ResultQuery: " + db.executeQuery("SELECT * FROM invoice limit 10"));
//        }
//

//        HashMap<String, String> messageTemplate = new HashMap<>();
//        messageTemplate.put("name", "Int[10-30]");
//        messageTemplate.put("age", "String[10-20]");
//        messageTemplate.put("vwucdcivhw", "Array<int>");
//
        ArrayList<JSONObject> rows = db.executeQuery("SELECT * FROM invoice limit 10");
//        ArrayList<String> messages = new KafkaMessageGenerator().messageGenerator(1_000_000, messageTemplate);
//        kafkaService.sendMessage("topicTEn", "Hello, worldssddsdsdsss!"); //key null
//        kafkaService.sendMessageKey("topicTEST_Key", "1fff", "testValueDSDS");
        kafkaService.sendMessageBatch("ToBeOrNotToBe5", rows, 0);
//
//                -----------Test of messages-----------
        db.executeQuery("SELECT * FROM invoice limit 10").forEach(System.out::println);

    }

}



