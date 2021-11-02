import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException, SQLException {
//        KafkaService kafkaService = new KafkaService();

        Connection connection = new Connection();
        System.out.println(connection.dbConnection("SELECT * FROM invoice LIMIT 10"));

//        System.out.println(new ConnectionConfigPars().geturl());


//        HashMap<String, String> messageTemplate = new HashMap<>();
//        messageTemplate.put("name", "Int[10-30]");
//        messageTemplate.put("age", "String[10-20]");
//        messageTemplate.put("vwucdcivhw", "Array<int>");

//        ArrayList<String> messages = new KafkaMessageGenerator().messageGenerator(1_000_000, messageTemplate);
//        kafkaService.sendMessage("topicTEn", "Hello, worldssddsdsdsss!"); //key null
//        kafkaService.sendMessageKey("topicTEST_Key", "1fff", "testValueDSDS");
//        kafkaService.sendMessageBatch("ToBeOrNotToBe2", messages, 1);
//        Thread.sleep(20 * 1000);


//                -----------Test of messages-----------
//        messages.forEach(System.out::println);

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

}



