import java.io.*;
import java.sql.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Connection {

    public ResultSet dbConnection(String sqlRequest) throws IOException, ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputFileConfig = new FileInputStream(new File("..\\KafkaSend\\config.json"));
        Config dbConfig = objectMapper.readValue(new String(inputFileConfig.readAllBytes()), Config.class);

        Statement statementSource = connection(dbConfig.db).createStatement();

        ResultSet resultSet = statementSource.executeQuery(sqlRequest);

return resultSet;
    }
    public static java.sql.Connection connection (ParsingConfigFile parsingConfigFile) throws SQLException {
        return DriverManager.getConnection(parsingConfigFile.geturl(),
                parsingConfigFile.getUser(),
                parsingConfigFile.getPassword());
    }
//    public void executeQuery (String sqlRequest){
//        Statement statementSource = connection(configSource.source).createStatement();
//        ResultSet resultSet = statementSource.executeQuery(sqlRequest);
//        System.out.println(resultSet);
//    }
}
