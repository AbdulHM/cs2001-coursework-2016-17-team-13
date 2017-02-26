package com.example.abdul.wishlistenter;

import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MediaNames {

    public static ArrayList<String> getNameList(String apiEndPoint) throws InterruptedException, ExecutionException {
        final ArrayList<String> namelist = new ArrayList<String>();
        GraphRequest.Callback gCallback = new GraphRequest.Callback() {
            @Override
            public void onCompleted(GraphResponse response) {
                final JSONObject jsonObject = response.getJSONObject();
                try {
                    JSONArray data = jsonObject.getJSONArray("data");
                    for(int i=0; i<data.length(); i++) {
                        JSONObject objectData = data.getJSONObject(i);
                        namelist.add(objectData.getString("name"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        final GraphRequest graphRequest = new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/" + AccessToken.getCurrentAccessToken().getUserId() + "/" + apiEndPoint,
                null,
                HttpMethod.GET,
                gCallback
        );

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString("limit", "100");
                graphRequest.setParameters(bundle);
                GraphResponse gResponse = graphRequest.executeAndWait();
            }
        });
        t.start();
        t.join();
        return namelist;
    }

}
