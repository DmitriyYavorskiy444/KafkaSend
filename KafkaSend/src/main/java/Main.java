import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        KafkaService kafkaService = new KafkaService();

        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Int[10-30]");
        map.put("age", "String[10-20]");
        map.put("vwucdcivhw", "Array<int>");

        ArrayList<String> messages = new KafkaMessageGenerator().generateJson(5, map);
//        kafkaService.sendMessage("topicTEn", "Hello, worldssddsdsdsss!"); //key null
//        kafkaService.sendMessageKey("topicTEST_Key", "1fff", "testValueDSDS");
        kafkaService.sendMessageBatch("ToBeOrNotToBe", messages, 1);


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



