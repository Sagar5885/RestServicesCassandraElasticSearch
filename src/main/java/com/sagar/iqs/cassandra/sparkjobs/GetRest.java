package com.sagar.iqs.cassandra.sparkjobs;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

//import com.sagar.iqs.cassandra.sparkjobs.common.EndPointTester;
import com.sagar.iqs.cassandra.sparkjobs.common.HttpMethodType;
import com.sagar.iqs.cassandra.sparkjobs.common.ServiceUtils;

public class GetRest {

	static ServiceUtils serviceUtils = new ServiceUtils();
	//static EndPointTester endPointTester = new EndPointTester();
	
	public static void main(String args[]){
		String getRequest = "URL";
		//String getResponse1 = serviceUtils.httpMethodWithHeaders(getRequest, endPointTester.getHeadersIQS(new HttpGet()), HttpMethodType.GET, null);
		//System.out.println(getResponse1);
	}
}
