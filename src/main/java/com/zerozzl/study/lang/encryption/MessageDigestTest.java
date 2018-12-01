package com.zerozzl.study.lang.encryption;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

public class MessageDigestTest {

	private static String MD5(String s) {
		String msg = null;
		try {
			/**
			 * MD5 SHA-1 SHA-256
			 */
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(s.getBytes("utf-8"));
			byte[] bytes = md.digest();
			msg = Base64.encodeBase64String(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public static void main(String[] args) {
		System.out.println(MessageDigestTest.MD5("Test"));
	}

}
