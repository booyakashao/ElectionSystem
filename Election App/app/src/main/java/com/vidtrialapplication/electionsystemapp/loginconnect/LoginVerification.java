package com.vidtrialapplication.electionsystemapp.loginconnect;

import com.electionsystemapp.utils.JSONUtils;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

/**
 * Created by wengu on 3/14/15.
 */
public class LoginVerification {

    public static String URL_LOGIN = "http://smashthebeetles.com:8083/androidlogin/";

    public static Voter httpRequestAttempt(String username, String password) throws Exception {
        HttpClient httpClient = new DefaultHttpClient();

        //url with post data
        HttpPost httpPost = new HttpPost(URL_LOGIN);

        //Creating JSON Object
        AndroidLogin loginCredentials = new AndroidLogin("admin", "password");
        JSONObject androidJSON = JSONUtils.loginToJSON(loginCredentials);

        StringEntity stringEntity = new StringEntity("");
        try {
            stringEntity = new StringEntity(androidJSON.toString());
        } catch(Exception e) {
            e.printStackTrace();
        }

        httpPost.setEntity(stringEntity);

        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        ResponseHandler responseHandler = new BasicResponseHandler();
        String responseTest = (String) httpClient.execute(httpPost, responseHandler);

        return JSONUtils.jsonToVoter(responseTest);
    }
}
