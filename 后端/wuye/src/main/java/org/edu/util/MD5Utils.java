package org.edu.util;

import java.security.MessageDigest;
import java.text.NumberFormat;


public class MD5Utils {
	private static long MaxID = 999999999999L;
	private static int keyLen = 12;
	
	/**
	 * 
	 * 获取字符串加密后结果
	 * 
	 * @param text
	 *            需要加密的字符串
	 * @return
	 */
	public static String md5(String text) {
		return md5(text, null);
	}

	/**
	 * 获取字符串加密后结果
	 * 
	 * @param text
	 * @param prifix
	 * @return
	 */
	public static String md5(String text, String prifix) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

		if(null!=prifix && !"".endsWith(prifix)){
			text = prifix + text;
		}
		byte[] originalByte = text.getBytes();
		md5.update(originalByte);

		byte[] newByte = md5.digest();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < newByte.length; i++) {
			if ((newByte[i] & 0xff) < 0x10) {
				stringBuilder.append("0");
			}
			stringBuilder.append(Long.toString(newByte[i] & 0xff, 16));
		}
		return stringBuilder.toString().toUpperCase();
	}
	
	public static String md5(String text, long userId) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

		text = formatKey(userId) + text;

		byte[] originalByte = text.getBytes();
		md5.update(originalByte);

		byte[] newByte = md5.digest();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < newByte.length; i++) {
			if ((newByte[i] & 0xff) < 0x10) {
				stringBuilder.append("0");
			}
			stringBuilder.append(Long.toString(newByte[i] & 0xff, 16));
		}
		return stringBuilder.toString().toUpperCase();
	}
	
	/**
	 * 
	 * 方法描述： FORMATEKEY
	 * @param id
	 * @return
	 */
	public static String formatKey(long id) {
		if (id > MaxID) {
			return String.valueOf(id);
		}
		// 得到一个NumberFormat的实例
		NumberFormat nf = NumberFormat.getInstance();
		// 设置是否使用分组
		nf.setGroupingUsed(false);
		// 设置最大整数位数
		nf.setMaximumIntegerDigits(keyLen);
		// 设置最小整数位数
		nf.setMinimumIntegerDigits(keyLen);
		return nf.format(id);
	}
	
}
