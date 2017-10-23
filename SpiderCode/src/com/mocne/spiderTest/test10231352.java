package com.mocne.spiderTest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class test10231352 {
	private static HttpClient httpClient = new HttpClient();
//	static {
//		httpClient.getHostConfiguration().setProxy("172.17.18.84", 8080);
//	}
	
	public static boolean downloadPage(String path) throws HttpException, IOException{
		InputStream input = null;
		OutputStream output = null;
		PostMethod postMethod = new PostMethod(path);
		NameValuePair[] postData = new NameValuePair[2];
		postData[0] = new NameValuePair("name","leitu");
		postData[1] = new NameValuePair("password","******");
		postMethod.addParameters(postData);
		
		int statusCode = httpClient.executeMethod(postMethod);
		if (statusCode == HttpStatus.SC_OK) {
			input = postMethod.getResponseBodyAsStream();
			String filename = path.substring(path.lastIndexOf('/') + 1);
			output = new FileOutputStream(filename);
			int tempByte = -1;
			while ((tempByte = input.read()) > 0) {
				output.write(tempByte);
			}
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
			return true;
		}
		return false;
		 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			test10231352.downloadPage("https://www.baidu.com/");
			
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
