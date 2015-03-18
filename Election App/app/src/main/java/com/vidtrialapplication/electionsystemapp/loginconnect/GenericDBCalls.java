package com.vidtrialapplication.electionsystemapp.loginconnect;

import com.electionsystemapp.utils.JSONUtils;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by wengu on 3/18/15.
 */
public class GenericDBCalls {

    public static String URL_LOGIN = "http://smashthebeetles.com:8083/androidlogin/getAllVoters/";

    public static String[] getAllUsernames() throws Exception {
        HttpClient httpClient = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet(URL_LOGIN);

        httpGet.setHeader("Accept", "application/json");
        httpGet.setHeader("Content-type", "application/json");

        ResponseHandler responseHandler = new BasicResponseHandler();
        String responseTest = (String) httpClient.execute(httpGet, responseHandler);
        return JSONUtils.ListOfAllVoters(responseTest);
    }
}
