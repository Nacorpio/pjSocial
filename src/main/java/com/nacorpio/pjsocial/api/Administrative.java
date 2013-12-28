package com.nacorpio.pjsocial.api;

import com.nacorpio.pjsocial.util.HttpUtil;

/*
 * I dont know a correct name for this yet, temporarily calling it 'Administrative'.
 */
public class Administrative {

	public static final Object initialize(String api_key, String plugin_version, String hardware_id, String server_port){
		try {
			String var1 = HttpUtil.getSource("http://pjsocial.lightifylife.com/api/initialize?apikey=" + api_key + "&version=" + plugin_version + "&hwid=" + hardware_id + "&port=" + server_port);
			/*
			 * TODO: 
			 *  - Convert var1 (JSON) to an useable array.
			 *  - Return the array
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
