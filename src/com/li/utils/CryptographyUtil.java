package com.li.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

import com.li.entity.Car;


/**
 * 密码加密的工具类
 */
public class CryptographyUtil {

	/**
	 * md5加密,普通用户加密
	 */
	public static String md5User(String str,String salt){
		return new Md5Hash(str, salt, 10).toString();
	}
	
	/**
	 * md5加密,管理员加密
	 */
	public static String md5Manager(String str,String salt){
		return new Md5Hash(str, salt, 1024).toString();
	}
}
