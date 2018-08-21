package com.example.devansh.demoprojectoath.Parser;

import android.os.AsyncTask;
import android.util.Log;

import com.example.devansh.demoprojectoath.API.APIConstants;
import com.example.devansh.demoprojectoath.PoJo.NewsPojo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import static com.example.devansh.demoprojectoath.API.APIConstants.url;

/**
 * Created by Devansh on 8/21/2018.
 */

public class GetData extends AsyncTask<Void,Void,String>{

    private String api_url= APIConstants.url;
    //public List<NewsPojo> res_list = new ArrayList<NewsPojo>();

    @Override
    protected String doInBackground(Void... voids) {

            try {
                URL url = new URL(api_url);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuilder.toString();
                }
                finally{
                    urlConnection.disconnect();
                }
            }
            catch(Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(s == null) {
            s = "THERE WAS AN ERROR";
        }
        try {
            storeData(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void storeData(String s) throws JSONException {
        try {
            JSONObject obj = new JSONObject(s),obj1=null;
            System.out.println(s);
            JSONArray arr1 = obj.getJSONArray("items");
            JSONArray arr2 = arr1.getJSONArray(0);
            for(int i =0;i<arr2.length();i++){
                obj1 = new JSONObject("content");
                NewsPojo o = new NewsPojo();
                o.setTitle(obj1.getString("title"));
                o.setWeb_url(obj1.getString("url"));
                JSONArray arr3 = obj1.getJSONArray("images");
                JSONObject obj2 = arr3.getJSONObject(0);
                o.setImage(obj2.getString("originalUrl"));
                APIConstants.list.add(o);
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}


