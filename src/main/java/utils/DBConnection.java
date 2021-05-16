package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnection {
		
	public ArrayList connectMysqlDB(String sql){
	
		ArrayList <String> dbValue = new ArrayList<String>();
		
		String host ="localhost";
		String port ="3306";
		String dbName = "udemyLearning";

			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+dbName ,"root","root");
				Statement stmt =con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()){
					for (int i=1 ; i<= rs.getMetaData().getColumnCount(); i++){
						dbValue.add(rs.getString(i));
					}
				}	
				con.close();
			} catch (Exception e) {			
				e.printStackTrace();
			}
			return dbValue;
		}
}
