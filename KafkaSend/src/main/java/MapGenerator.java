import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

public class MapGenerator {

    public HashMap<String,String> generateMap(HashMap<String, String> map) {
        HashMap<String,String> resultMap = new HashMap<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey();

            if (value.contains("String")) {
                resultMap.put(key,generateString(value));
            }
            if (value.contains("Int")) {
                resultMap.put(key,generateInt(value));
            }
            if (value.contains("Array")) {
                resultMap.put(key,generateArrayInt());
            }

        }
    return resultMap;
    }
    private String generateString(String str) {
        return RandomStringUtils.random(valueLenght(str),true,false);
    }
    private String generateInt(String str){
        return RandomStringUtils.random(valueLenght(str),false,true);
    }
    private String generateArrayInt(){
        int [] a = new int[5];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(RandomStringUtils.random(3,false,true));
        }
        return Arrays.toString(a);
    }
    private int valueLenght(String str){
        String[] subStr = str.split("-");
        int minRes = Integer.parseInt(subStr[0].replaceAll("[^0-9]", ""));
        int maxRes = Integer.parseInt(subStr[1].replaceAll("[^0-9]", ""));
        return new Random().nextInt(maxRes+1-minRes) + minRes;
    }
}