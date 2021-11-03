import java.io.*;
import java.sql.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbService {
    private final Statement connectionStatement;

    public DbService() throws IOException, ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputFileConfig = new FileInputStream("..\\KafkaSend\\config.json");
        Config dbConfig = objectMapper.readValue(new String(inputFileConfig.readAllBytes()), Config.class);
        this.connectionStatement = connection(dbConfig.db).createStatement();
        System.out.println("DbService is initialized");
    }
    public ArrayList<JSONObject> executeQuery (String sqlRequest) throws SQLException, IOException, ClassNotFoundException {
        ArrayList<JSONObject> resList = new ArrayList<>();
//        HashMap<String,Object> resultMap = new HashMap<>();
        ResultSet setOfRows = connectionStatement.executeQuery(sqlRequest);
//        // -------- column names ----------
//        ResultSetMetaData rsMeta = execute.getMetaData();
//        int columnCnt = rsMeta.getColumnCount();
//        List<String> columnNames = new ArrayList<>();
//        for(int i=1;i<=columnCnt;i++) {
//            columnNames.add(rsMeta.getColumnName(i));
//        }
//        // ------- converting ---------
//        while(execute.next()) {
//            JSONObject obj = new JSONObject();
//            for (int i = 1; i <= columnCnt; i++) {
//                String key = columnNames.get(i - 1);
//                String value = execute.getString(i);
//                obj.put(key, value);
//            }
//            resList.add(obj);
//        }
        ResultSetMetaData getColumnsValues = setOfRows.getMetaData();

        while(setOfRows.next()) {
          JSONObject jsonObject = new JSONObject();
//            int numColumns = getColumnsValues.getColumnCount();
            for (int i=1; i<=getColumnsValues.getColumnCount(); i++) {
                String column_name = getColumnsValues.getColumnName(i);
//                resultMap.put(column_name, setOfRows.getObject(column_name));
                jsonObject.put(column_name, setOfRows.getObject(column_name));
//                System.out.printf(" K: %s, V: %s", column_name, setOfRows.getObject(column_name));
            }
//            for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
//                Object value = entry.getValue();
//                String key = entry.getKey();
//                System.out.println(key+" : "+value);
//            }
          resList.add(jsonObject);
        }
        System.out.println("Executing Query...Done");
        return resList;
    }
    private static Connection connection (ConnectionParameters parameters) throws SQLException {
        System.out.println("Connection...Done");
        return DriverManager.getConnection(parameters.geturl(),
                parameters.getUser(),
                parameters.getPassword());
    }
}
