import java.io.*;
import java.sql.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

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
    public ArrayList<String> executeQuery (String sqlRequest) throws SQLException {
        ResultSet setOfRows = connectionStatement.executeQuery(sqlRequest);
        DataConverter toJSON = new DataConverter();
        System.out.println("Executing Query...Done");
        return toJSON.convertToJSON(setOfRows);
    }
    private static Connection connection (ConnectionParameters parameters) throws SQLException {
        System.out.println("Connection...Done");
        return DriverManager.getConnection(parameters.geturl(),
                parameters.getUser(),
                parameters.getPassword());
    }
}
