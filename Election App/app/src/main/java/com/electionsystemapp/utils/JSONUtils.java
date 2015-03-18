package com.electionsystemapp.utils;

import com.vidtrialapplication.electionsystemapp.loginconnect.AndroidLogin;
import com.vidtrialapplication.electionsystemapp.loginconnect.Voter;

import org.json.JSONException;
import org.json.JSONObject;

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

    //List all voter usernames
    public static void ListOfAllVoters(String jsonString) {

    }
}
