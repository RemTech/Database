package com.dbservice;

import com.dbconfig.DBProperties;
import com.dbconfig.DatabaseConnection;
import static org.junit.Assert.*;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database_Service {

 private Connection conn=null;
 private Statement statement;
 private ResultSet resultSet;

    @Test
    public void accessDB() throws SQLException {
        try{
            /* Database connection with it's properties */

            conn=DatabaseConnection.getDBConnection(DBProperties.getProperties("database.url"), DBProperties.getProperties("database.username"),DBProperties.getProperties("database.password"));
            String dbName= conn.getMetaData().getDatabaseProductName();
            System.out.println(dbName);
            statement=conn.createStatement();
            resultSet=statement.executeQuery(DBProperties.getProperties("database.query"));
            while(resultSet.next()){
                String id=resultSet.getString(1);
                int Id=Integer.parseInt(id);
                assertEquals(1,Id);
                System.out.println(Id);
               String firstName=resultSet.getString(2);
               assertEquals("Wayne",firstName);
                System.out.println(firstName);
                String lastName=resultSet.getString(3);
                assertEquals("Lane",lastName);
                System.out.println(lastName);
                String phone=resultSet.getString(4);
                assertEquals("019130401230",phone);
                System.out.println(phone);
                break;
            }
        }catch (SQLException sqlException){
            sqlException.getLocalizedMessage();
        }finally {
            conn.close();
        }

    }
}
