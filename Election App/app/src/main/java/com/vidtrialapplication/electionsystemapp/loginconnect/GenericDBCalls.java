package com.vidtrialapplication.electionsystemapp.loginconnect;

import com.electionsystemapp.utils.JSONUtils;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

/**
 * Created by wengu on 3/18/15.
 */
public class GenericDBCalls {

    private static String URL_GET_ALL_VOTERS = "http://smashthebeetles.com:8083/androidlogin/getAllVoters/";
    private static String URL_GET_VOTER_BY_ID = "http://smashthebeetles.com:8083/androidlogin/voterid/";

    public static String[] getAllUsernames() throws Exception {
        HttpClient httpClient = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet(URL_GET_ALL_VOTERS);

        httpGet.setHeader("Accept", "application/json");
        httpGet.setHeader("Content-type", "application/json");

        ResponseHandler responseHandler = new BasicResponseHandler();
        String responseTest = (String) httpClient.execute(httpGet, responseHandler);
        return JSONUtils.ListOfAllVoters(responseTest);
    }

    public static Voter getVoterById(long id) throws Exception {
        HttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost(URL_GET_VOTER_BY_ID);

        JSONObject voterLoginJSON = JSONUtils.voterIdOnlyToJSON(id);

        StringEntity stringEntity = new StringEntity("");
        try {
            stringEntity = new StringEntity(voterLoginJSON.toString());
        } catch(Exception e) {
            e.printStackTrace();
        }

        httpPost.setEntity(stringEntity);

        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        ResponseHandler responseHandler = new BasicResponseHandler();
        String responseText = (String) httpClient.execute(httpPost, responseHandler);

        return JSONUtils.jsonToVoter(responseText);
    }
}
