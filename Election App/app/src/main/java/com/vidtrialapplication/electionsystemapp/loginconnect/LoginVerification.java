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

    public static String URL_LOGIN = "http://192.168.3.6:8080/ElectionWebAdministration/androidlogin/";

    public static void httpRequestAttempt() throws Exception {
        HttpClient httpClient = new DefaultHttpClient();

        //url with post data
        HttpPost httpPost = new HttpPost(URL_LOGIN);

        //Creating JSON Object
        AndroidLogin loginCredentials = new AndroidLogin("voter","password");
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
        httpClient.execute(httpPost, responseHandler);
        //JSONObject jsonObj = (JSONObject) httpClient.execute(httpPost, responseHandler);
    }
}
