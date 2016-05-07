package com.sozunyi.xiaolimao.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * ��ȡ���Ĺ���
 * 
 */
public class StreamUtils {

	/**
	 * ������ȡ��STRING�󷵻�
	 * @throws IOException 
	 * 
	 */
	public static String readStream(InputStream is) throws IOException
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		int len = 0;
		byte[] buffer = new  byte[1024];

			while((len=is.read(buffer)) != -1)
			{
				out.write(buffer,0,len);
			}
			String result = out.toString();
			is.close();
			out.close();
			return result;
	}
}
