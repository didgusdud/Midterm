package ku.opensrcsw._Midterm;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;
import org.json.simple.parser.*;

public class midterm1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the keyword you are looking for: ");
    	String input = in.next();
    	
		JSONParser jsonParser = new JSONParser();
		 try(Reader reader= new FileReader("c:\\midterm\\midterm.json")){
         	 
             JSONObject jsonObject = (JSONObject)jsonParser.parse(reader);
             JSONArray infoArray = (JSONArray)jsonObject.get(input);
             
             String outValue = null;
             if(jsonObject.has(input)){
            	 try{
            		 outValue = jsonObject.getString(input);
            		 
            	 }catch(JSONException e){
            		 e.printStackTrace();
            	 }
             }
             
             for(int i=0; i<infoArray.size();i++){
            	 
          
             	JSONObject itemObject =(JSONObject)infoArray.get(i);
             	System.out.println("item "+i+":"+itemObject.get("item"));
             		
             }
             //Iterator<String> iterator = infoArray.iterator();
             
             }catch(ParseException ex){
             	ex.printStackTrace();
             }catch(IOException e){
            	 e.printStackTrace();
             }

	}

}
