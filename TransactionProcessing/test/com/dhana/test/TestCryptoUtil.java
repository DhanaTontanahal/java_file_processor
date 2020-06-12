package com.dhana.test;

import com.gb.cs.encrypt.CryptoUtil;

public class TestCryptoUtil {
	
	public static void main(String[] args) throws Exception {
        CryptoUtil cryptoUtil=new CryptoUtil();
        String key="ezeon8547";   
        String plain="Dhana@12tds";
        String enc=cryptoUtil.encrypt(key, plain);
        System.out.println("Original text: "+plain);
        System.out.println("Encrypted text: "+enc);
        String plainAfter=cryptoUtil.decrypt(key, enc);
        System.out.println("Original text after decryption: "+plainAfter);
    }

}
