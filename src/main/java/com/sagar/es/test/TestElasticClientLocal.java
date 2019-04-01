package com.sagar.es.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestElasticClientLocal {
	
    private final static String ES_URL = "http://localhost:9200";
	private final static String ES_INDEX = "jug";

	ElasticClient elastic = new ElasticClient(ES_URL);
	
	public static void main(String args[]) throws IOException {
			Talk talk1 = new Talk("Stainless Steel", 8);
			addToElasctic(talk1);
	}
	
	private static void addToElasctic(Talk talk) {
		ElasticClient elastic = new ElasticClient(ES_URL);
		Map<String, Object> payLoad = objectify(talk);
		System.out.println(payLoad);
		if(payLoad != null) {
			// Post to Elastic
			String type = "talk";
			try {
				if (!elastic.indexExists(ES_INDEX)) {
					elastic.createIndex(ES_INDEX);
				}
				elastic.post(ES_INDEX, type, payLoad);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Problem with results for elasticIndex: "+ ES_INDEX);
		}
		System.out.println("Completed");
	}
	
	private static Map<String, Object> objectify(Talk talk){
		Map<String, Object> result = new HashMap<>();
		
		result.put("madeOff", talk.madeOff);
		result.put("cost", talk.cost);
		
		return result;
	}
}
