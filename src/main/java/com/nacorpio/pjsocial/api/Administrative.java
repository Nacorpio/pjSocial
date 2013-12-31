package com.nacorpio.pjsocial.api;

import java.util.HashMap;

import com.nacorpio.pjsocial.util.HttpUtil;
import com.nacorpio.pjsocial.util.JSONUtil;

/*
 * I dont know a correct name for this yet, temporarily calling it 'Administrative'.
 */
public class Administrative {

	public static final HashMap<String, String> initialize(String api_key, String plugin_version, String hardware_id, String server_port){
		String var1 = "";
		
		try {
			var1 = HttpUtil.getSource("http://pjsocial.lightifylife.com/api/initialize?apikey=" + api_key + "&version=" + plugin_version + "&hwid=" + hardware_id + "&port=" + server_port);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(var1.isEmpty()){
			HashMap<String, String> var2 = new HashMap<String, String>();
			var2.put("valid", "false");
			var2.put("message", "Something bad happened.");
			return var2;
		} else {
			return JSONUtil.getValues(var1);
		}
	}
	
}
