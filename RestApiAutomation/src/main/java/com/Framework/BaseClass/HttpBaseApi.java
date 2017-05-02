package com.Framework.BaseClass;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class HttpBaseApi {

	String endPoint = "https://api.twitter.com/1.1/";
	protected HttpClient client = HttpClientBuilder.create().build();
	final OAuthConsumer consumer;
	// Constructor- write the consumer keys in constructor to avoid writing them for each method 
	public HttpBaseApi(){

		// OAuthConsumer is the Interface // consumer key and value
		consumer = new CommonsHttpOAuthConsumer("xfi6ETFybtWTq6r705TlVeSpP","8bsZlEyH7lPl9g2gjvjflp1AeiLD6rVL53omajqnxiYTzSa2oR");
		// access token and access token secret value
		consumer.setTokenWithSecret("854501582309736448-s0PLhZLD0HlyLHE8ecHN1i9qI57Ybl6","2aWg1igcrlUjXz8ESBkWJL2eXYv7y8BOQ51bNZYzUuKIM");

	}
	public HttpGet get(String resource){
		HttpGet get = new HttpGet(endPoint+resource);

		try {
			consumer.sign(get);
		} catch (OAuthMessageSignerException e) {
			e.printStackTrace();
		} catch (OAuthExpectationFailedException e) {
			e.printStackTrace();
		} catch (OAuthCommunicationException e) {
			e.printStackTrace();
		}

		return get;
	}

	public HttpPost post(String resource){
		HttpPost post = new HttpPost(endPoint+resource);

		try {
			consumer.sign(post);
		} catch (OAuthMessageSignerException e) {
			e.printStackTrace();
		} catch (OAuthExpectationFailedException e) {
			e.printStackTrace();
		} catch (OAuthCommunicationException e) {
			e.printStackTrace();
		}
		return post;

	}
	/*public HttpDelete delete(String resource){
		HttpDelete del = new HttpDeletet(endPoint+resource);
		return del;
		}
	public HttpPost put(String resource){
		HttpPost put = new HttpPut(endPoint+resource);
		return put;
		}*/
}
