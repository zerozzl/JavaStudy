package com.zerozzl.study.lang.encryption;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;

import com.zerozzl.study.common.ConvertUtils;

public class SymmetricEncryptionTest {

	/**
	 * DES加密字符串
	 */
	public static String encryptDES(String data,
			String secretKey,
			String algorithm) throws Exception {
		// 创建一个密钥工厂，用它将DESKeySpec转化成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithm);
		// 从原始密钥数据创建DESKeySpec对象
		SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes("utf-8"), algorithm);
		SecretKey securekey = keyFactory.generateSecret(keySpec);
		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(algorithm);
		// 用密钥初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, new SecureRandom(secretKey.getBytes()));
		// 将加密后的数据编码成字符串
		byte[] result = cipher.doFinal(data.getBytes());
		return ConvertUtils.bytesToHexString(result);
	}

	public static String decryptDES(String data,
			String secretKey,
			String algorithm) throws Exception {
		// 创建一个密钥工厂，用它将DESKeySpec转化成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithm);
		// 从原始密钥数据创建DESKeySpec对象
		SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes("utf-8"), algorithm);
		SecretKey securekey = keyFactory.generateSecret(keySpec);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(algorithm);
		// 用密钥初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, new SecureRandom(secretKey.getBytes()));
		// 将加密后的数据解码再解密
		byte[] buf = cipher.doFinal(ConvertUtils.hexStringToBytes(data));
		return new String(buf);
	}

	/**
	 * AES加密字符串
	 */
	public static String encryptAES(String data,
			String secretKey,
			String algorithm) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance(algorithm); // 创建AES的Key生产者
		kgen.init(128, new SecureRandom(secretKey.getBytes())); // 利用用户密码作为随机数初始化出128位的key生产者
		// 加密没关系，SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以解密只要有password就行
		SecretKey securekey = kgen.generateKey(); // 根据用户密码，生成一个密钥
		SecretKeySpec key = new SecretKeySpec(securekey.getEncoded(), algorithm); // 转换为AES专用密钥
		Cipher cipher = Cipher.getInstance(algorithm); // 创建密码器
		cipher.init(Cipher.ENCRYPT_MODE, key); // 初始化为加密模式的密码器
		byte[] result = cipher.doFinal(data.getBytes("utf-8")); // 加密
		return ConvertUtils.bytesToHexString(result); // 加密
	}

	/**
	 * 解密AES加密过的字符串
	 */
	public static String decryptAES(String data,
			String password,
			String algorithm) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance(algorithm); // 创建AES的Key生产者
		kgen.init(128, new SecureRandom(password.getBytes()));
		SecretKey secretKey = kgen.generateKey(); // 根据用户密码，生成一个密钥
		SecretKeySpec key = new SecretKeySpec(secretKey.getEncoded(), algorithm); // 转换为AES专用密钥
		Cipher cipher = Cipher.getInstance(algorithm); // 创建密码器
		cipher.init(Cipher.DECRYPT_MODE, key); // 初始化为解密模式的密码器
		byte[] result = cipher.doFinal(ConvertUtils.hexStringToBytes(data));
		return new String(result); // 明文
	}

	public static void main(String[] args) throws Exception {
		String data = "my message";
		String secretKey = "csair_des_key"; // 密钥长度至少为8
		String desAlgorithm = "DES", aesAlgorithm = "AES";

		// DES加密
		String desCiphertext = encryptDES(data, secretKey, desAlgorithm);
		System.out.println("DES加密后为: " + desCiphertext);
		// DES解密
		String dtext = decryptDES(desCiphertext, secretKey, desAlgorithm);
		System.out.println("DES解密后为: " + dtext);

		// AES加密
		String aesCiphertext = encryptAES(data, secretKey, aesAlgorithm);
		System.out.println("AES加密后为: " + aesCiphertext);
		// AES解密
		String atext = decryptAES(aesCiphertext, secretKey, aesAlgorithm);
		System.out.println("AES解密后为: " + atext);
	}

}
