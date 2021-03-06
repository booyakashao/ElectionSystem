package com.electionsystemapp.utils;

import com.vidtrialapplication.electionsystemapp.loginconnect.AndroidLogin;
import com.vidtrialapplication.electionsystemapp.loginconnect.Candidate;
import com.vidtrialapplication.electionsystemapp.loginconnect.Voter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wengu on 3/16/15.
 */
public class JSONUtils {

    public static JSONObject loginToJSON(AndroidLogin androidLogin) {
        try{
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("username", androidLogin.getUsername());
            jsonObj.put("password", androidLogin.getPassword());


            return jsonObj;
        } catch(JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static JSONObject idOnlyToJSON(long id) {
        try {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("id", id);

            return jsonObj;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static JSONObject castVoteJSON(long candidateId, long voterId) {
        try {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("voterId", voterId);
            jsonObj.put("candidateId", candidateId);

            return jsonObj;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Voter jsonToVoter(String jsonString) {
        try {
            JSONObject finalObject = new JSONObject(jsonString);
            Voter returnedVoter = new Voter();

            returnedVoter.setId(finalObject.getLong("id"));
            returnedVoter.setUsername(finalObject.getString("username"));
            returnedVoter.setRoleName(finalObject.getJSONObject("role").getString("roleName"));

            return returnedVoter;
        } catch(JSONException e) {
            e.printStackTrace();

            return new Voter();
        }

    }

    public static Candidate jsonToCandidate(String jsonString) {
        try {
            JSONObject finalObject = new JSONObject(jsonString);
            Candidate returnedCandidate = new Candidate();

            returnedCandidate.setId(finalObject.getLong("id"));
            returnedCandidate.setName(finalObject.getString("name"));
            returnedCandidate.setDescription(finalObject.getString("description"));

            return returnedCandidate;
        } catch(JSONException e) {
            e.printStackTrace();

            return new Candidate();
        }
    }

    //List all voter usernames
    public static String[] ListOfAllVoters(String jsonString) {
        try {
            JSONArray stringArray = new JSONArray(jsonString);
            int size = stringArray.length();
            String[] listOfUsernames = new String[size];

            for(int i = 0; i < size; i++) {
                listOfUsernames[i] = (String) stringArray.get(i);
            }

            return listOfUsernames;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Candidate> ListAllCandidates(String jsonString) {
        try {
            JSONArray candidateArray = new JSONArray(jsonString);
            int size = candidateArray.length();
            List<Candidate> listOfCandidates = new ArrayList<Candidate>();

            for(int i = 0; i < size; i++) {
                JSONObject currentCandidate = (JSONObject) candidateArray.get(i);
                Candidate newCandidate = new Candidate();

                newCandidate.setId(currentCandidate.getLong("id"));
                newCandidate.setName(currentCandidate.getString("name"));
                newCandidate.setDescription(currentCandidate.getString("description"));

                listOfCandidates.add(newCandidate);
            }

            return listOfCandidates;
        } catch (JSONException e) {
            e.printStackTrace();
            return new ArrayList<Candidate>();
        }
    }
}
