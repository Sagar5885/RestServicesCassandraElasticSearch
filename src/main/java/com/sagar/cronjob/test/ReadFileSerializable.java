package com.sagar.cronjob.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFileSerializable {
	
	public static void main(String args[]) {
		try {
			FileInputStream fstream = new FileInputStream("/PathToFile/ReadLogFile.log");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String test;
			 while ((test = br.readLine()) != null)   {
				 System.out.println (test);
				 
				//Offer Id
				Pattern OfferPtn = Pattern.compile("offers/[0-9a-fA-F]{32}",Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
				Matcher Offermchr = OfferPtn.matcher(test);
				if(Offermchr.find()) {
					System.out.println(Offermchr.group().substring(7, 39));
				}
				
				//Host
				Pattern hostPtrn = Pattern.compile("app-[0-9,-]{19}");
				Matcher hostMchr = hostPtrn.matcher(test);
				if(hostMchr.find()) {
					System.out.println(hostMchr.group().substring(0, 28));
				}
				
				//Time
				Pattern timePtrn = Pattern.compile("[0-9,-]{10}\\s"+"[0-9,:,.]{12}");
				Matcher timeMchr = timePtrn.matcher(test);
				if(timeMchr.find()) {
					System.out.println(timeMchr.group());
				}
				
				//Consumer Id
				Pattern consumerIdPtrn = Pattern.compile("ConsumerId=[0-9a-f,-]{36}",Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
				Matcher consumerIdMchr = consumerIdPtrn.matcher(test);
				if(consumerIdMchr.find()) {
					System.out.println(consumerIdMchr.group().substring(11, 47));
				}
			
				//Env
				if(test.contains("env")) {
					System.out.println("ENV");
					Pattern dcCloudPtrn = Pattern.compile("env-[0-9a-z]{4}");
					Matcher dcCloudMchr = dcCloudPtrn.matcher(test);
					if(dcCloudMchr.find()) {
						System.out.println(dcCloudMchr.group());
					}
				}
								
				//Status
				Pattern statusPtrn = Pattern.compile("StatusCode=[0-9]{3}");
				Matcher statusMchr = statusPtrn.matcher(test);
				if(statusMchr.find()) {
					String Status = statusMchr.group();
					System.out.println(Status);
					if(Status.equals("StatusCode=200")) {
						System.out.println("OK");
					}else if(Status.equals("StatusCode=206")) {
						System.out.println("PARTIAL");
					}else {
						System.out.println("FAIL");
					}
				}
				
				System.out.println ();
				
			   }
			   fstream.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
