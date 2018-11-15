package com.zerozzl.study.lang.encryption;

import java.security.MessageDigest;

import com.zerozzl.study.common.ConvertUtils;

public class MessageDigestTest {

	private static String MD5(String s) {
		try {
			/**
			 * MD5 SHA-1 SHA-256
			 */
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(s.getBytes("utf-8"));
			byte[] bytes = md.digest();
			return ConvertUtils.bytesToHexString(bytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		System.out.println(MessageDigestTest.MD5("Test"));
	}

}
