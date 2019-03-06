package com.lanhuispace.utils;

import java.util.regex.Matcher;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/***
	PassWord ps = new PasswordRules();
	ps.sendPassword("~");
	System.out.println("DataMessage:"+ps.getData());
***/

public class PasswordRules
{
	private String password;
	private Map<String, Object> DataMap;
	private List<Map<String, Object>> DataList = new ArrayList<Map<String, Object>>();
	
	public PasswordRules()
	{
		this.password = null;
		this.DataMap = new HashMap<String, Object>();
		this.DataMap.put("isPass",true);
		this.DataMap.put("data",null);
	}

	/// 开始验证过程
	/// protected 对同一包内的类和所有子类可见
	///
	protected void VerifyPassword()
	{		
		boolean len = this.VerifyPasswordLength();
		boolean reg = this.VerifyPasswordRegex();
		boolean upp = this.VerifyPasswordUpper();//大写字母
		boolean low = this.VerifyPasswordLower();//小写字母
		boolean num = this.VerifyPasswordNumber();
		
		
		this.DataMap.put("data",this.DataList);
		if( !len || !reg )
		{
			this.DataMap.put("isPass",false);
		}
	}
	
	///
	/// 必须包含一个大写字母
	///
	protected boolean VerifyPasswordUpper()
	{
		boolean isUpperCase = false;
		for( int i=0;i<this.password.length();i++ )
		{
			char c = this.password.charAt(i);
			if( Character.isUpperCase(c) ){
				isUpperCase = true;
				break;
			}
		}
		
		if(!isUpperCase){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", 3);
			map.put("message", "必须至少包含一个大写字母");
			this.DataList.add(map);
		}
		return isUpperCase;
	}
	
	///
	/// 必须包含一个小写字母
	///
	protected boolean VerifyPasswordLower()
	{
		boolean isLowerCase = false;
		for( int i=0;i<this.password.length();i++ )
		{
			char c = this.password.charAt(i);
			if( Character.isLowerCase(c) ){
				isLowerCase = true;
				break;
			}
		}
		if(!isLowerCase){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", 4);
			map.put("message", "必须至少包含一个小写字母");
			this.DataList.add(map);
		}
		return isLowerCase;
	}
	
	///
	/// 必须包含一个数字
	///
	protected boolean VerifyPasswordNumber()
	{
		boolean isNumber = false;
		for( int i=0;i<this.password.length();i++ )
		{
			char c = this.password.charAt(i);
			if( Character.isDigit(c) ){
				isNumber = true;
				break;
			}
		}
		if(!isNumber){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", 5);
			map.put("message", "必须至少包含一个数字号码");
			this.DataList.add(map);
		}
		return isNumber;
	}
	
	///
	/// 密码长度校验
	/// 
	protected boolean VerifyPasswordLength()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		map.put("message", null);
		if( this.password.length() < 8 )
		{
			map.put("message", "密码长度必须至少8个字符");
			this.DataList.add(map);
			return false;
		}
		return true;
	}
	
	///
	/// 字符验证
	///
	protected boolean VerifyPasswordRegex()
	{
		String RegexPassword = "([A-Z]|[a-z]|[0-9]|!|@|#|_|-){0,}";
		if(this.password.matches(RegexPassword)){
			return true;
		}else{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", 2);
			map.put("message", "字符必须是字母、数字、个别特殊符号（! @ # _ -）");
			this.DataList.add(map);
			return false;
		}
	}	
	
	/// 
	/// 外部调用时 发送过来的密码
	///
	public void sendPassword(String pass)
	{
		this.password = pass.trim();
	}
	
	///
	/// 返回密码是否通过验证
	///
	public boolean getVerifyPassword(String pass)
	{
		this.sendPassword(pass);
		this.getData();
		return (java.lang.Boolean)this.DataMap.get("isPass");
	}
	
	///
	/// 返回详细的数据 
	///
	public Map<String, Object> getData()
	{
		if(this.password==null){
			return null;
		}else{
			this.VerifyPassword();
			return this.DataMap;
		}
	}
}