import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataConverter {

    public ArrayList<String> convertToJSON(ResultSet setOfRows) throws SQLException, JSONException {
        ResultSetMetaData getColumnsValues = setOfRows.getMetaData();
        ArrayList<String> rows = new ArrayList<>();

        while(setOfRows.next()) {
            int numColumns = getColumnsValues.getColumnCount();
            JSONObject row = new JSONObject();

            for (int i=1; i<numColumns+1; i++) {
                String columnName = getColumnsValues.getColumnName(i);

                if(getColumnsValues.getColumnType(i)==java.sql.Types.ARRAY){
                    row.put(columnName, setOfRows.getArray(columnName));
                }
                else if(getColumnsValues.getColumnType(i)==java.sql.Types.BIGINT){
                    row.put(columnName, setOfRows.getLong(columnName));
                }
                else if(getColumnsValues.getColumnType(i)==java.sql.Types.BOOLEAN){
                    row.put(columnName, setOfRows.getBoolean(columnName));
                }
                else if(getColumnsValues.getColumnType(i)==java.sql.Types.BLOB){
                    row.put(columnName, setOfRows.getBlob(columnName));
                }
                else if(getColumnsValues.getColumnType(i)==java.sql.Types.DOUBLE){
                    row.put(columnName, setOfRows.getDouble(columnName));
                }
                else if(getColumnsValues.getColumnType(i)==java.sql.Types.FLOAT){
                    row.put(columnName, setOfRows.getFloat(columnName));
                }
                else if(getColumnsValues.getColumnType(i)==java.sql.Types.INTEGER){
                    row.put(columnName, setOfRows.getInt(columnName));
                }
                else if(getColumnsValues.getColumnType(i)==java.sql.Types.NVARCHAR){
                    row.put(columnName, setOfRows.getNString(columnName));
                }
                else if(getColumnsValues.getColumnType(i)==java.sql.Types.VARCHAR){
                    row.put(columnName, setOfRows.getString(columnName));
                }
                else if(getColumnsValues.getColumnType(i)==java.sql.Types.TINYINT){
                    row.put(columnName, setOfRows.getInt(columnName));
                }
                else if(getColumnsValues.getColumnType(i)==java.sql.Types.SMALLINT){
                    row.put(columnName, setOfRows.getInt(columnName));
                }
                else if(getColumnsValues.getColumnType(i)==java.sql.Types.DATE){
                    row.put(columnName, setOfRows.getDate(columnName));
                }
                else if(getColumnsValues.getColumnType(i)==java.sql.Types.TIMESTAMP){
                    row.put(columnName, setOfRows.getTimestamp(columnName));
                }
                else{
                    row.put(columnName, setOfRows.getObject(columnName));
                }
            }
            rows.add(row.toString());
        }
        return rows;
    }
}
