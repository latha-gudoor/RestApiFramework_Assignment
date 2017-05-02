package com.Framework.RestApiAutomation;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

import com.Framework.BaseClass.HttpBaseApi;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class TwitterRestApi extends HttpBaseApi {

	public HttpResponse getData(String resource) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException{
		HttpGet get = get(resource);

		HttpResponse response=null;
		get.addHeader("content-type","application/json;charset=utf-8");

		response = client.execute(get);
		return response;
	}

	// post method used to create the resource or update the resource-- hence need to give the request data 
	public HttpResponse postData(String resource,JSONObject req) {

		HttpResponse response = null;

		// URI -- get it from documentation
		HttpPost post = post(resource);
		try {

			//json object need to be converted to string using 
			StringEntity entity = new StringEntity(req.toString());

			//Setting the request Entity / request Payload to Post method 
			post.setEntity(entity);
			post.addHeader("Contect-type","application/json");

			response = client.execute(post);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return response;
	}
}






/*public HttpResponse postMethod() throws ClientProtocolException, IOException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException{

		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = null;

		HttpPost post = new HttpPost("https://api.twitter.com/1.1/account/update_profile.json?name=Sri&description=RestAPI");
		//JSONObject jsonObj = new JSONObject();
		//StringEntity entity = new StringEntity(jsonObj.toString());
		///jsonObj.put("name","sri");
		//jsonObj.put("location","sfo");
		//post.addHeader("content-type","applications/json");
		//post.setEntity(entity);
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer("xfi6ETFybtWTq6r705TlVeSpP","8bsZlEyH7lPl9g2gjvjflp1AeiLD6rVL53omajqnxiYTzSa2oR");
		consumer.setTokenWithSecret("854501582309736448-s0PLhZLD0HlyLHE8ecHN1i9qI57Ybl6","2aWg1igcrlUjXz8ESBkWJL2eXYv7y8BOQ51bNZYzUuKIM");
		consumer.sign(post);
		response = client.execute(post);

		return response;

	}*/


/*//method with httpResponse as the return 
	public HttpResponse getData(){
		HttpClient client = HttpClientBuilder.create().build(); //

		// getting the response using program (automating)
		HttpGet get = new HttpGet("https://api.twitter.com/1.1/account/settings.json");
		HttpResponse response=null;
		// we can add headers using addHeader method which takes key and value pair
		get.addHeader("content-Type", "application/json");

		// add oauth
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer("GHbqBHxYoV6PY7JGC6F9PviRX","AVFg71bfZZt8WEK2dRZXF4PAKAUuIkjEGXUgdFEhCPO4ORAFHs");
		consumer.setTokenWithSecret("854501582309736448-s0PLhZLD0HlyLHE8ecHN1i9qI57Ybl6", "2aWg1igcrlUjXz8ESBkWJL2eXYv7y8BOQ51bNZYzUuKIM");
		try {
			consumer.sign(get);
			//execute the request using the client opbject which takes HttpURIRequest and we get back a httpResponse
			response = client.execute(get);
		} catch (OAuthMessageSignerException e1) {
			e1.printStackTrace();
		} catch (OAuthExpectationFailedException e1) {
			e1.printStackTrace();
		} catch (OAuthCommunicationException e1) {
			e1.printStackTrace();
		}
		catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	return response;

	}*/
