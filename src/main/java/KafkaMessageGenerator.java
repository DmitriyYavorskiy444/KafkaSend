import org.json.JSONObject;

import java.util.*;

public class KafkaMessageGenerator {

    public ArrayList<String> messageGenerator(int count, HashMap<String, String> map) {
        ArrayList<String> messages = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            messages.add(new JSONObject(new MapGenerator().generateMap(map)).toString());
        }
        return messages;
    }
}