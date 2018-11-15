package com.zerozzl.study.lang.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {

	public static void baseTest(String uri) {
		try {
			URL url = new URL(uri);
			System.out.println("URL 为：" + url.toString());
			System.out.println("协议为：" + url.getProtocol());
			System.out.println("验证信息：" + url.getAuthority());
			System.out.println("文件名及请求参数：" + url.getFile());
			System.out.println("主机名：" + url.getHost());
			System.out.println("路径：" + url.getPath());
			System.out.println("端口：" + url.getPort());
			System.out.println("默认端口：" + url.getDefaultPort());
			System.out.println("请求参数：" + url.getQuery());
			System.out.println("定位位置：" + url.getRef());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.runoob.com");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String urlString = "";
			String current;
			while ((current = in.readLine()) != null) {
				urlString += current;
			}
			System.out.println(connection.getContentType());
			System.out.println(connection.getContentEncoding());
			System.out.println(urlString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
