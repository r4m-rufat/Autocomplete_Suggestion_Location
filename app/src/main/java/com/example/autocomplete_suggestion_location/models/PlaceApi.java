package com.example.autocomplete_suggestion_location.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class PlaceApi {

    public ArrayList<String> autoComplete(String input) {

        ArrayList arrayList = new ArrayList();

        HttpURLConnection connection = null;

        StringBuilder jsonResult = new StringBuilder();
        try {

            StringBuilder stringBuilder = new StringBuilder("https://maps.googleapis.com/maps/api/place/autocomplete/json?");
            stringBuilder.append("input=" + input);
            stringBuilder.append("&types=(cities)");
            stringBuilder.append("&key=YOUR_APIKEY");
            URL url = new URL(stringBuilder.toString());
            connection = (HttpURLConnection) url.openConnection();
            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());

            int read;

            char[] buffer = new char[1000];

            while ((read = inputStreamReader.read(buffer))!=-1){

                jsonResult.append(buffer, 0, read);

            }

        }catch (MalformedURLException e){

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }finally {

            if (connection!=null){

                connection.disconnect();
            }

        }

        try {

            JSONObject jsonObject = new JSONObject(jsonResult.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("predictions");
            for (int i  = 0; i < jsonArray.length(); i++){

                arrayList.add(jsonArray.getJSONObject(i).getString("description"));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return arrayList;

    }


}
