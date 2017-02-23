package com.example.abdul.wishlistenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static android.R.attr.data;
import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {

    LoginButton loginButton;
    TextView textView;
    CallbackManager callbackManager;
    private ArrayList<String> namelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        loginButton= (LoginButton)findViewById(R.id.login_button);
        textView= (TextView)findViewById(R.id.login_text);
        callbackManager= CallbackManager.Factory.create();
        loginButton.setReadPermissions(Arrays.asList("user_likes"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                startActivity(new Intent(MainActivity.this, MainMenu.class));

//                new GraphRequest(
//                        AccessToken.getCurrentAccessToken(),
////                        "/" + loginResult.getAccessToken().getUserId() + "/movies",
//                        "/" + AccessToken.getCurrentAccessToken().getUserId() + "/movies",
//                        null,
//                        HttpMethod.GET,
//                        new GraphRequest.Callback() {
//                            public void onCompleted(GraphResponse response) {
//                                final JSONObject jsonObject = response.getJSONObject();
//                                namelist = new ArrayList<String>();
//
//                                try {
//                                    JSONArray data = jsonObject.getJSONArray("data");
//
//                                    for(int i=0; i<data.length(); i++) {
//                                        JSONObject objectData = data.getJSONObject(i);
//                                        namelist.add(objectData.getString("name"));
//                                    }
//
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//
//                                for (int i = 0; i < namelist.size();i++) {
//                                    Log.d("Main", namelist.get(i));
//                                }
//                                Log.d("Main", "THIS HAS BEEN RUN");
//                            }
//            /* handle the result */
//                        }
//
//                ).executeAsync();
//                MediaNames mediaNames = new MediaNames();
                try {
                    namelist = MediaNames.getMovieNames("books");
                } catch (Exception e) {
                    Log.e("Main", "onSuccess: ", e);
                }

//
                Log.d("Main", namelist.size()+"");
                for (int i = 0; i < namelist.size() ;i++) {
                    Log.d("Main", namelist.get(i));
                }



            }

            @Override
            public void onCancel() {
                textView.setText("Login Cancelled");

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }


}
