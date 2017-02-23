package com.example.abdul.wishlistenter;

import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Abdul on 10/02/2017.
 */

public class MediaNames {



    public ArrayList<String> getmovieNames(){
        final ArrayList<String> namelist = new ArrayList<String>();
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/" + AccessToken.getCurrentAccessToken().getUserId() + "/movies",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        final JSONObject jsonObject = response.getJSONObject();
//                        namelist = new ArrayList<String>();

                        try {
                            JSONArray data = jsonObject.getJSONArray("data");


                            for(int i=0; i<data.length(); i++) {
                                JSONObject objectData = data.getJSONObject(i);
                                namelist.add(objectData.getString("name"));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        for (int i = 0; i < namelist.size();i++) {

//                            Log.d("Main", namelist.get(i));

                        }
//                        Log.d("Main",  "ty ");


                    }
                /* handle the result */
                }

        ).executeAsync();

        return namelist;


    }
//
//        public  ArrayList<String> getArrayList(){
//
//        return namelist;
//    }


}
