package org.kian.mulesoft;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpClient {
	public static void main(String[] args) {
		HttpClient http = new HttpClient();
		http.ping("http://www.google.com");
	}

	private boolean ping(String https_url)  {
		boolean isUp = false;
		URL obj = null;
		HttpURLConnection con = null;
		try{
			obj = new URL(https_url);
			con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			System.out.println("Pinging URL : " + https_url);
			System.out.println("Response Code : " + con.getResponseCode());

			isUp = true;
		}catch(Exception ex){
           //ex.printStackTrace();
		}finally{
			con.disconnect();
		}
	    System.out.println("Is URL Up : " + isUp);
		return isUp;
	}



}