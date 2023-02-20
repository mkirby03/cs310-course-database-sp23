package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class DAOUtility {
    
    public static final int TERMID_SP23 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {

                // INSERT YOUR CODE HERE
                ResultSetMetaData rsmd = rs.getMetaData();
                int numCols = rsmd.getColumnCount();
                List<String> columnName = new ArrayList<>();
                //int[] columnTypes = new int[numCols];
                for (int i = 1; i <= numCols; i++)
                {
                    columnName.add(rsmd.getColumnName(i));
                }
                
                while (rs.next())
                {
                    JsonObject jsonRecord = new JsonObject();
                    //LinkedHashMap<String, Integer> jsonRecord = new LinkedHashMap<>();
                    for (int i = 1; i <= numCols; i++)
                    {
                        //columnName.add(rsmd.getColumnName(i));
                        //String columnName = rsmd.getColumnName(i);
                        jsonRecord.put(columnName.get(i - 1), rs.getString(i));
                    }
                    records.add(jsonRecord);
                }
                
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}
