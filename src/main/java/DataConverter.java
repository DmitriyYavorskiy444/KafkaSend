import org.json.JSONException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DataConverter {

    public ArrayList<String> convertToJSON(ResultSet setOfRows) throws SQLException, JSONException {
        ArrayList<String> jsonRows = new ArrayList<>();
        while (setOfRows.next()) {
            jsonRows.add(setOfRows.getObject(1).toString());
        }
        return jsonRows;
    }
}
