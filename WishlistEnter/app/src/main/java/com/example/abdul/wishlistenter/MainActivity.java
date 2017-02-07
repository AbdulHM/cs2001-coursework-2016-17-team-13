package com.example.abdul.wishlistenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import java.util.Arrays;
import java.util.Map;

import static android.R.attr.data;
import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {

    LoginButton loginButton;
    TextView textView;
    CallbackManager callbackManager;


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
               // textView.setText("Login Succesful \n" + loginResult.getAccessToken().getUserId() + "\n" + loginResult.getAccessToken().getToken());

                new GraphRequest(
                        AccessToken.getCurrentAccessToken(),
                        "/" + loginResult.getAccessToken().getUserId() + "/movies",
                        null,
                        HttpMethod.GET,
                        new GraphRequest.Callback() {
                            public void onCompleted(GraphResponse response) {
                                // textView.setText("__________________RESPONSE"+response);
                                //for(int i=0; i<response.length; i++) {
                                final JSONObject jsonObject = response.getJSONObject();


                                try {
                                    //JSONObject movies = jsonObject.getJSONObject("movies");
                                    JSONArray data = jsonObject.getJSONArray("data");
                                     StringBuilder names = new StringBuilder();;

                                    for(int i=0; i<data.length(); i++) {
                                        JSONObject objectdata = data.getJSONObject(i);
                                        String name = objectdata.getString("name");
                                       names.append(name);
                                    }
                                    textView.setText("__________________RESPONSE" + names.toString());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }




//                                    JSONObject jUsers =  jsonObject.getJSONObject("movies");
//                                    JSONObject jData =  jUsers.getJSONObject("data");
//                                    char[][] data;
//
//                                    for(int i=0; i<jData.length(); i++) {
//                                        JSONObject c = jData.getJSONObject(String.valueOf(i));
//                                        String name = c.getString("name");
//                                        textView.setText("__________________RESPONSE"+response);
//                                    }


                            }
            /* handle the result */
                        }

                ).executeAsync();
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
