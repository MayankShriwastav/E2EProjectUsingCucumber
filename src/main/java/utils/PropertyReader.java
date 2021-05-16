package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import PageObject.BaseClass;

public class PropertyReader extends BaseClass {
		
		public PropertyReader(WebDriver driver){
			super(driver);
		}
	
	private  final static String ENV_FILE_PATH = "D:/My_Projects/Automation/src/main/java/Properties/envParams.json";
	private  final static String DB_Query = "D:/My_Projects/Automation/src/main/java/Properties/dbQuery.json";
	
	public String getUrl() throws IOException, ParseException{
		return getEnvValue("url","uat");
	}
	public String getUserName() throws IOException, ParseException{
		return getEnvValue("userName","uat");
	}
	public String getPassword() throws IOException, ParseException{
		return getEnvValue("password","uat");
	}
		
	private String getEnvValue(String parameter, String tagName) throws IOException, ParseException{		
		JSONParser jsonParser = new JSONParser();		
		JSONObject jsonObj = (JSONObject)jsonParser.parse(new FileReader(ENV_FILE_PATH));
		JSONArray jsonArr  = (JSONArray)jsonObj.get("envs");
		
		for(int i= 0 ; i<jsonArr.size() ; i++){
			JSONObject env = (JSONObject)jsonArr.get(i);
			String envTag = (String)env.get("tag");
			if(envTag.equals(tagName)){
				return (String)env.get(parameter);
			}			
		}	
		return null;	
	}
	
	public String getQuery() throws IOException, ParseException{
		return getSqlQuery("register","select");
	}
	
	private String getSqlQuery(String query, String queryType) throws IOException, ParseException{		
		JSONParser jsonParser = new JSONParser();		
		JSONObject jsonObj = (JSONObject)jsonParser.parse(new FileReader(DB_Query));
		JSONArray jsonArr  = (JSONArray)jsonObj.get("query");
		
		for(int i= 0 ; i<jsonArr.size() ; i++){
			JSONObject qryType = (JSONObject)jsonArr.get(i);
			String qryTag = (String)qryType.get("tag");
			if(qryTag.equals(queryType)){
				return (String)qryType.get(query);
			}			
		}	
		return null;	
	}
	
}
