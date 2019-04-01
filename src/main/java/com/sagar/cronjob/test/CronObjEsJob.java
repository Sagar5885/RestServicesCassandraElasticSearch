package com.sagar.cronjob.test;

import java.io.IOException;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Index;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.IndicesExists;

public class CronObjEsJob implements Job{
	
	String OfferId = "Offer1";
	CronObj cronObj = new CronObj(OfferId, "1", "1.2.3.4", "cd1", "c1", "error", "c1", new Date());

	public void setData(Object obj, String index, String type, String id) throws IOException {
        JestClientFactory jestClientFactory = new JestClientFactory();
        jestClientFactory.setHttpClientConfig(new HttpClientConfig
                .Builder("http://localhost:9200")
                .multiThreaded(true)
                .build());
        JestClient jclient = jestClientFactory.getObject();
        
//		boolean indexExist = jclient.execute(new IndicesExists.Builder(index).build()).isSucceeded();
//		if(indexExist) {
//			jclient.execute(new DeleteIndex.Builder(index).build());
//		}else {
//			jclient.execute(new CreateIndex.Builder(index).build());
//		}
        
        jclient.execute(new Index.Builder(obj).index(index).type(type).id(id).build());
    }
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			setData(cronObj, "test_cp5", "history1", OfferId);
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
