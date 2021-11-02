import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

public class MapGenerator {

    public HashMap<String,Object> generateMap(HashMap<String, String> map) {
        HashMap<String,Object> resultMap = new HashMap<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey();
//            min,max = getMinMax(value); // python example

            if (value.contains("String")) {
                resultMap.put(key,generateString(value));
//                resultMap.put(key,generateString(min: 10, max: 30)); // preferable to exist
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
        String[] subStr = str.split("-");
        int min = Integer.parseInt(subStr[0].replaceAll("[^0-9]", ""));
        int max = Integer.parseInt(subStr[1].replaceAll("[^0-9]", ""));
        int valueLength = new Random().nextInt(max+1-min) + min;
        return RandomStringUtils.random(valueLength,true,false);
    }
    private int generateInt(String str){
        String[] subStr = str.split("-");
        int min = Integer.parseInt(subStr[0].replaceAll("[^0-9]", ""));
        int max = Integer.parseInt(subStr[1].replaceAll("[^0-9]", ""));
        return new Random().nextInt(max+1-min) + min;
    }

    private int[] generateArrayInt(){
        int [] a = new int[5];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(900) + 100;
        }
        return a;
    }
    private int valueLength(String str){
        String[] subStr = str.split("-");
        int minRes = Integer.parseInt(subStr[0].replaceAll("[^0-9]", ""));
        int maxRes = Integer.parseInt(subStr[1].replaceAll("[^0-9]", ""));
        return new Random().nextInt(maxRes+1-minRes) + minRes;
    }
}