package Beanhelp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
 public  String converByteToHexString(byte[] bytes) //
 {
	String result="";
	for(int i=0;i<bytes.length;i++)
	{
		int temp = bytes[i] & 0xff;  //ֵ
		String tempHex = Integer.toHexString(temp);//�˷������ص��ַ�����ʾ���޷���������������ʾ��ֵ��ʮ�����ƣ�����Ϊ16��.
		if(tempHex.length()<2)
		{result +="0"+tempHex;}else //��λ
		{result += tempHex;}
	}
	return result; 
	}
 public  String md5jm(String message){
	String temp = "";
	try {
		MessageDigest md5Digest = MessageDigest.getInstance("MD5");
	      // �õ�һ��MD5ת����
		byte[] encodeMd5Digest = md5Digest.digest(message.getBytes());//getBytes���ַ���ת��Ϊ�ֽ�����
		temp = converByteToHexString(encodeMd5Digest);//���÷���
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return temp;
	 
	 
 }
 
 
}
