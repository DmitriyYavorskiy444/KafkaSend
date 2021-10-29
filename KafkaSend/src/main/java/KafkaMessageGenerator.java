import java.util.*;

public class KafkaMessageGenerator {

    public ArrayList<String> generateJson(int count, HashMap<String, String> map){
        ArrayList<String> list = new ArrayList<>();
        String jsonPattern;
        String patternBlock;
            for (int i = 0; i < count; i++) {
                jsonPattern = "{";
                Iterator<Map.Entry<String, String>> entries = new MapGenerator().generateMap(map).entrySet().iterator();
                while (entries.hasNext()) {
                    Map.Entry<String, String> entry = entries.next();
                    patternBlock = String.format("\"%s\":\"%s\"",
                                entry.getKey(),
                                entry.getValue());
                    jsonPattern = jsonPattern + patternBlock;
                    if(entries.hasNext()){ jsonPattern = jsonPattern+",";}
                }
                jsonPattern=jsonPattern+"}";
                list.add(jsonPattern);
            }
        return list;
    }
}
