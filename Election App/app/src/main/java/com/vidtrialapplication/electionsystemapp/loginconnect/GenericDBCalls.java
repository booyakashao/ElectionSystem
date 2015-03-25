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

import java.util.List;

/**
 * Created by wengu on 3/18/15.
 */
public class GenericDBCalls {

    private static String URL_GET_ALL_VOTERS = "http://smashthebeetles.com:8083/androidlogin/getAllVoters/";
    private static String URL_GET_VOTER_BY_ID = "http://smashthebeetles.com:8083/androidlogin/voterid/";
    private static String URL_GET_VOTER_CANDIDATE = "http://smashthebeetles.com:8083/androidvote/votercandidate/";
    private static String URL_GET_ALL_CANDIDATES = "http://smashthebeetles.com:8083/androidvote/allcandidates/";
    private static String URL_GET_CANDIDATE_BY_ID = "http://smashthebeetles.com:8083/androidvote/candidatepage/";
    private static String URL_CAST_VOTE = "http://smashthebeetles.com:8083/androidvote/castvote/";

    /*
    private static String URL_GET_ALL_VOTERS = "http://192.168.3.6:8080/ElectionWebAdministration/androidlogin/getAllVoters/";
    private static String URL_GET_VOTER_BY_ID = "http://192.168.3.6:8080/ElectionWebAdministration/androidlogin/voterid/";
    private static String URL_GET_VOTER_CANDIDATE = "http://192.168.3.6:8080/ElectionWebAdministration/androidvote/votercandidate/";
    private static String URL_GET_ALL_CANDIDATES = "http://192.168.3.6:8080/ElectionWebAdministration/androidvote/allcandidates/";
    private static String URL_GET_CANDIDATE_BY_ID = "http://192.168.3.6:8080/ElectionWebAdministration/androidvote/candidatepage/";
    private static String URL_CAST_VOTE = "http://192.168.3.6:8080/ElectionWebAdministration/androidvote/castvote/";
    */
    public static String[] getAllUsernames() throws Exception {
        HttpClient httpClient = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet(URL_GET_ALL_VOTERS);

        httpGet.setHeader("Accept", "application/json");
        httpGet.setHeader("Content-type", "application/json");

        ResponseHandler responseHandler = new BasicResponseHandler();
        String responseText = (String) httpClient.execute(httpGet, responseHandler);
        return JSONUtils.ListOfAllVoters(responseText);
    }

    public static Voter getVoterById(long id) throws Exception {
        HttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost(URL_GET_VOTER_BY_ID);

        JSONObject voterLoginJSON = JSONUtils.idOnlyToJSON(id);

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

    public static Candidate getVoterCandidate(long voterId) throws Exception {
        HttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost(URL_GET_VOTER_CANDIDATE);

        JSONObject voterLoginJSON = JSONUtils.idOnlyToJSON(voterId);

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

        return JSONUtils.jsonToCandidate(responseText);
    }

    public static List<Candidate> getAllCandidates() throws Exception {
        HttpClient httpClient = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet(URL_GET_ALL_CANDIDATES);

        httpGet.setHeader("Accept", "application/json");
        httpGet.setHeader("Content-type", "application/json");

        ResponseHandler responseHandler = new BasicResponseHandler();
        String responseText = (String) httpClient.execute(httpGet, responseHandler);

        return JSONUtils.ListAllCandidates(responseText);
    }

    public static Candidate getCandidateById(long candidateId) throws Exception {
        HttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost(URL_GET_CANDIDATE_BY_ID);

        JSONObject candidateIdJSON = JSONUtils.idOnlyToJSON(candidateId);

        StringEntity stringEntity = new StringEntity("");
        try {
            stringEntity = new StringEntity(candidateIdJSON.toString());
        } catch(Exception e) {
            e.printStackTrace();
        }

        httpPost.setEntity(stringEntity);

        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        ResponseHandler responseHandler = new BasicResponseHandler();
        String responseText = (String) httpClient.execute(httpPost, responseHandler);

        return JSONUtils.jsonToCandidate(responseText);
    }

    public static void castVote(long candidateId, long voterId) throws Exception {
        HttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost(URL_CAST_VOTE);

        JSONObject castVoteJSON = JSONUtils.castVoteJSON(candidateId, voterId);

        StringEntity stringEntity = new StringEntity("");
        try {
            stringEntity = new StringEntity(castVoteJSON.toString());
        } catch(Exception e) {
            e.printStackTrace();
        }

        httpPost.setEntity(stringEntity);

        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        ResponseHandler responseHandler = new BasicResponseHandler();
        String responseText = (String) httpClient.execute(httpPost, responseHandler);
    }
}
