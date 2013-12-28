package com.nacorpio.pjsocial.api;

import java.util.HashMap;

import com.nacorpio.pjsocial.util.HttpUtil;
import com.nacorpio.pjsocial.util.JSONUtil;

/*
 * I dont know a correct name for this yet, temporarily calling it 'Administrative'.
 */
public class Administrative {

	public static final Object initialize(String api_key, String plugin_version, String hardware_id, String server_port){
		HashMap<String, String> error;
		try {
			String var1 = HttpUtil.getSource("http://pjsocial.lightifylife.com/api/initialize?apikey=" + api_key + "&version=" + plugin_version + "&hwid=" + hardware_id + "&port=" + server_port);
			return JSONUtil.getValues(var1);
		} catch (Exception e) {
			error = new HashMap<String, String>();
			error.put("valid", "false");
			error.put("message", e.getMessage());
		}
		return error;
	}
	
}
