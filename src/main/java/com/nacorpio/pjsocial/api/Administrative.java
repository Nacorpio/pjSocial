package com.nacorpio.pjsocial.api;

import java.util.HashMap;

import com.nacorpio.pjsocial.util.DebugUtil;
import com.nacorpio.pjsocial.util.HttpUtil;
import com.nacorpio.pjsocial.util.JSONUtil;

/*
 * I dont know a correct name for this yet, temporarily calling it 'Administrative'.
 */
public class Administrative {

	public static final HashMap<String, String> initialize(String api_key, String plugin_version, String hardware_id, String server_port){
		HashMap<String, String> error = new HashMap<String, String>();
		try {
			String var1 = HttpUtil.getSource("http://pjsocial.lightifylife.com/api/initialize?apikey=" + api_key + "&version=" + plugin_version + "&hwid=" + hardware_id + "&port=" + server_port);
			DebugUtil.debug(var1);
			return JSONUtil.getValues(var1);
		} catch (Exception e) {
			error.put("valid", "false");
		}
		error.put("message", "ERROR: test");
		return error;
	}
	
}
