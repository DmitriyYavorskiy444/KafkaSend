import org.json.JSONObject;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, SQLException {
        KafkaService kafkaService = new KafkaService();

        Connection connection = new Connection();
        ResultSet resultSet = connection.dbConnection("SELECT to_jsonb(array_agg(invoice)) FROM invoice LIMIT 10");

//        HashMap<String, String> messageTemplate = new HashMap<>();
//        messageTemplate.put("name", "Int[10-30]");
//        messageTemplate.put("age", "String[10-20]");
//        messageTemplate.put("vwucdcivhw", "Array<int>");

//        ArrayList<String> messages = new KafkaMessageGenerator().messageGenerator(1_000_000, messageTemplate);
//        kafkaService.sendMessage("topicTEn", "Hello, worldssddsdsdsss!"); //key null
//        kafkaService.sendMessageKey("topicTEST_Key", "1fff", "testValueDSDS");
//        kafkaService.sendMessageBatch("ToBeOrNotToBe3", dbMessages(resultSet), 0.5);


//                -----------Test of messages-----------
        dbMessages(resultSet).forEach(System.out::print);

//                ---------MapGenerators Test ----------
//        System.out.println("Before");
//        MapGenerator mapGenerator = new MapGenerator();
//        mapGenerator.generateMap(map).forEach((k,v) -> System.out.println(v));
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            String value = entry.getValue();
//            String key = entry.getKey();
//            System.out.println(key+"|"+value);
//        }
//        System.out.println("After");
//        for (Map.Entry<String, String> entry : mapGenerator.generateMap(map).entrySet()) {
//            String value = entry.getValue();
//            String key = entry.getKey();
//            System.out.println(key+"|"+value);
//        }

    }
    public static ArrayList<String> dbMessages (ResultSet resultSet) throws SQLException {
        ArrayList<String> dbMessages = new ArrayList<>();

        int i = 1;
        while (resultSet.next()) {
            String data = String.format("%s : %s\n", i, resultSet.getString(1));
            System.out.print(data);
//            dbMessages.add(new JSONObject(resultSet.getString(1)).toString());
            i++;
        }
    return dbMessages;
    }
}



