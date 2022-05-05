package com.weavapi.base;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class sample {
	
	public static void main(String[] args) {

        JSONObject object = new JSONObject("{\"data\": [\n"
        		+ "                {\n"
        		+ "                    \"Answer\": \"I don't use Tinder\",\n"
        		+ "                    \"Question\": \"find me childrens movies with daniel radcliffe from the 2000s\",\n"
        		+ "                    \"Segment Description\": \"Duke University\",\n"
        		+ "                    \"Segment Type\": \"Web\",\n"
        		+ "                    \"Single\": true,\n"
        		+ "                    \"timestamp\": \"01/07/21\"\n"
        		+ "                }]}");
        JSONArray array = object.getJSONArray("data");
        Iterator<Object> iterator = array.iterator();
        ArrayList<String> cars = new ArrayList<String>();

        while (iterator.hasNext()) {
            JSONObject jsonObject = (JSONObject) iterator.next();

            for (String key : jsonObject.keySet()) {
            	
            	
                cars.add(key);
            }
            
            System.out.println(cars);
        }

    }

}
