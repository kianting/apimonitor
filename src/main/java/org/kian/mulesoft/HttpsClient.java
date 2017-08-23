package org.kian.mulesoft;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;
import java.io.*;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

public class HttpsClient{

   public static void main(String[] args)
   {
        new HttpsClient().ping("https://api.ccc.govt.nz/properties/v1/sales");
   }

   private boolean ping(String https_url){
	  boolean isUp = false;
      URL url;
      HttpsURLConnection con = null;
      try {

	     url = new URL(https_url);
	     con = (HttpsURLConnection)url.openConnection();
	     con.setRequestMethod("GET");
	     System.out.println("Pinging URL: " + https_url);
	     System.out.println("Response is: " + con.getResponseCode());
	     isUp = true;
      } catch (Exception ex){
    	  //ex.printStackTrace();
      }finally{
    	 if (con != null){
    		 con.disconnect();
    	 }
      }
      System.out.println("Is URL Up : " + isUp);
      return isUp;
   }
}