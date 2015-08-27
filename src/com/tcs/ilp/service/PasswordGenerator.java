package com.tcs.ilp.service;

public class PasswordGenerator {

	/*
	public static void main(String[] args) {		
		System.out.println(generatePassword());		
	}
	 */
		
	public static String generatePassword(){
		String lower = "abcdefghijklmnopqrstuvwxyz";
		String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String digits = "0123456789";
		String specialChars = "!@#$%^&*";
		int minimum = 0;
		int maximum;
		int n =8;     //PasswordLength
		
		StringBuilder sb = new StringBuilder();
		
		String set = lower + upper + digits + specialChars;    // characters to choose from
		maximum = set.length()-1;
		
		//System.out.println(set);
		
		for (int i= 0; i < n; i++) {
		    int k = minimum + (int)(Math.random()*maximum);;   // random number between 0 and set.length()-1 inklusive
		    sb.append(set.charAt(k));
		}
		String passWord = sb.toString();	
		//System.out.println(passWord);
		return passWord;
	}
}
