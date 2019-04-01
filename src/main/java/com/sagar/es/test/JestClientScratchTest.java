package com.sagar.es.test;

import java.io.IOException;
import java.util.List;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.core.SearchResult.Hit;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.IndicesExists;

public class JestClientScratchTest {

	public static void main(String args[]) throws IOException {
		JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(new HttpClientConfig.Builder("http://localhost:9200").multiThreaded(true).build());
		
		JestClient jclient = factory.getObject();
		
		//"jug" got created so commenting it now - otherwise loose data
		
//		boolean indexExist = jclient.execute(new IndicesExists.Builder("jug").build()).isSucceeded();
//		if(indexExist) {
//			jclient.execute(new DeleteIndex.Builder("jug").build());
//		}else {
//			jclient.execute(new CreateIndex.Builder("jug").build());
//		}
		
		//Data already created so don't keep duplicating it
		Talk talk1 = new Talk("Stainless Steel", 15);
//		
		jclient.execute(new Index.Builder(talk1).index("jug").type("talk").build());
		
		
		String query = "{\n" +
	            "    \"query\": {\n" +
	            "        \"match\" : {\n" +
	            "              \"madeOff\" : \"Stainless Steel\"\n" +
	            "        }\n" +
	            "    }\n" +
	            "}";
		
		Search.Builder searchBuilder = new Search.Builder(query).addIndex("jug").addType("talk");
		
		SearchResult result = jclient.execute(searchBuilder.build());

		List<Hit<Talk, Void>> hits = result.getHits(Talk.class);
        for (Hit<Talk, Void> hit: hits) {
            Talk talk = hit.source;
            System.out.println(talk.getMadeOff()+": "+talk.getCost());
        }
        
	}
}
