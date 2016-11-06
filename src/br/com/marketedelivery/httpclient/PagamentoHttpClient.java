package br.com.marketedelivery.httpclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import org.codehaus.jettison.json.JSONObject;

import com.mercadopago.MP;


public class PagamentoHttpClient{

	private final String USER_AGENT = "Mozilla/5.0";
	private final static String CLIENT_ID = "5952939985037689";
	private final static String CLIENT_SECRET = "sc6bzJ8ZWHkhAU3xnt0Krx0sq0DS2zcM";

	public static void main(String[] args) throws Exception {
		MP mp = new MP (PagamentoHttpClient.CLIENT_ID, PagamentoHttpClient.CLIENT_SECRET);
		JSONObject createPreferenceResult = mp.createPreference("{'items':[{'title':'Prueba','quantity':1,'currency_id':'ARS','unit_price':10.5}]}");
		//JSONObject preference = mp.getPreference("PREFERENCE_ID");
		System.out.println(createPreferenceResult.toString());
		//PagamentoHttpClient http = new PagamentoHttpClient();

		//System.out.println("Testing 1 - Send Http GET request");
		//http.sendGet();

		//System.out.println("\nTesting 2 - Send Http POST request");
		//http.sendPost();

	}
	
	@SuppressWarnings("unused")
	private void sendGet() throws Exception {

		String url = "http://www.google.com";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}
	
//	private void sendPost() throws Exception {
//
//		String url = "https://selfsolve.apple.com/wcResults.do";
//		URL obj = new URL(url);
//		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
//
//		//add request header
//		con.setRequestMethod("POST");
//		con.setRequestProperty("User-Agent", USER_AGENT);
//		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
//
//		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
//
//		// Send post request
//		con.setDoOutput(true);
//		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//		wr.writeBytes(urlParameters);
//		wr.flush();
//		wr.close();
//
//		int responseCode = con.getResponseCode();
//		System.out.println("\nSending 'POST' request to URL : " + url);
//		System.out.println("Post parameters : " + urlParameters);
//		System.out.println("Response Code : " + responseCode);
//
//		BufferedReader in = new BufferedReader(
//		        new InputStreamReader(con.getInputStream()));
//		String inputLine;
//		StringBuffer response = new StringBuffer();
//
//		while ((inputLine = in.readLine()) != null) {
//			response.append(inputLine);
//		}
//		in.close();
//
//		//print result
//		System.out.println(response.toString());
//
//	}
	



	  
	  

}
