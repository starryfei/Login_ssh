package com.action;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;

public class ActionDemo implements RequestAware,ApplicationAware {
	private Map<String, Object> request;
	private Map<String, Object> application;
	private String weather;
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String execute() {
		//
		return "success";
	}
	public String name() {
		request.get(getWeather());
		String httpArg = (String) request.get(getWeather());;
		request.put("json", getWeather());
		return "success";
	}
	public String getWheather() {
		String httpUrl = "http://apis.baidu.com/heweather/weather/free";
		
		String httpArg = "city="+weather;
		
		String jsonResult = request1(httpUrl, httpArg);
		request.put("json", jsonResult);
		System.out.println(httpArg);
		 System.out.println(jsonResult);
		return "success";
	}
	
	private String request1(String httpUrl, String httpArg) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		httpUrl = httpUrl + "?" + httpArg;
		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			// ÃÓ»ÎapikeyµΩHTTP header
			connection.setRequestProperty("apikey",
					"a34781fa4d3d14d55e0a5df576e77019");
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				// sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	@Override
	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.application =application;
	}

}
