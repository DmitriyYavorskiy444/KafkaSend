import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapGenerator {

    public HashMap<String, Object> generateMap(HashMap<String, String> map) {
        HashMap<String, Object> resultMap = new HashMap<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey();

            if (value.contains("String")) {
                resultMap.put(key, generateString(getLimits(value)));
            }
            if (value.contains("Int")) {
                resultMap.put(key, generateInt(getLimits(value)));
            }
            if (value.contains("Array")) {
                resultMap.put(key, generateArrayInt());
            }

        }
        return resultMap;
    }

    private String generateString(int[] limits) {
        int valueLength = new Random().nextInt(limits[1] + 1 - limits[0]) + limits[0];
        return RandomStringUtils.random(valueLength, true, false);
    }

    private int generateInt(int[] limits) {
        return new Random().nextInt(limits[1] + 1 - limits[0]) + limits[0];
    }

    private int[] generateArrayInt() {
        int[] a = new int[5];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(900) + 100;
        }
        return a;
    }

    private int[] getLimits(String str) {
        String[] subStr = str.split("-");
        int[] limits = new int[2];
        limits[0] = Integer.parseInt(subStr[0].replaceAll("[^0-9]", "")); // min
        limits[1] = Integer.parseInt(subStr[1].replaceAll("[^0-9]", "")); // max

//        int[] limits = new int[2];
//        Matcher m = Pattern.compile("([\\d]+)").matcher(str);
//        int i = 0;
//        while (m.find()) {
//            limits[i] = Integer.parseInt(m.group());
//            i++;
//        }
        return limits;
    }
}