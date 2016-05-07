package com.sozunyi.xiaolimao.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	/**
	 * MD5�����㷨
	 * @param password
	 * @return
	 */
	public static String encode(String password){
		try {
			MessageDigest instance = MessageDigest.getInstance("MD5");// ��ȡMD5�㷨����
			byte[] digest = instance.digest(password.getBytes());// ���ַ�������,�����ֽ�����

			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				int i = b & 0xff;// ��ȡ�ֽڵĵͰ�λ��Чֵ
				String hexString = Integer.toHexString(i);// ������תΪ16����				// System.out.println(hexString);

				if (hexString.length() < 2) {
					hexString = "0" + hexString;// �����1λ�Ļ�,��0
				}

				sb.append(hexString);
			}
			return sb.toString();
			//Md5����32λ
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			// û�и��㷨ʱ,�׳��쳣, �����ߵ�����
		}
		return "";
	}

}
