package com.electionsystemapp.utils;

import com.vidtrialapplication.electionsystemapp.loginconnect.AndroidLogin;

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
}
