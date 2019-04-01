package com.sagar.es.test;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.IndicesExists;

public class ElasticClient {

	private JestClient client = null;
	public static final int DEFAULT_MAX_ES_CLIENT_CONNECTIONS = 30;
	public static final int DEFAULT_MAX_ES_CLIENT_IDLE_TIME_IN_SEC = 30;
	public static final int DEFAULT_READ_TIMEOUT_IN_SEC = 30;
	
	public ElasticClient(String baseUrl) {
		init(baseUrl);
	}

	private void init(String baseUrl) {
		JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(new HttpClientConfig.Builder(baseUrl).multiThreaded(true)
				.maxTotalConnection(DEFAULT_MAX_ES_CLIENT_CONNECTIONS)
				.connTimeout(DEFAULT_MAX_ES_CLIENT_IDLE_TIME_IN_SEC * 1_000)
				.maxConnectionIdleTime(DEFAULT_MAX_ES_CLIENT_IDLE_TIME_IN_SEC, TimeUnit.SECONDS)
				.readTimeout(DEFAULT_READ_TIMEOUT_IN_SEC * 1_000).build());
		this.client = factory.getObject();
	}
	
	public JestClient getClient() {
		return this.client;
	}
	
	public void post(String index, String type, Map<String, Object> payload) throws IOException {
		JestResult doc = client.execute(new Index.Builder(payload).index(index).type(type).build());
		//System.out.println(doc.getJsonString());
	}

	public void post(String index, String type, Map<String, Object> payload, String _id) throws IOException {
		JestResult doc = client.execute(new Index.Builder(payload).index(index).id(_id).type(type).build());
		System.out.println(doc.getJsonString());
	}

	public void bulkPost(String index, String type, Map<String, Map<String, Object>> payloads) throws IOException {
		if (payloads == null || payloads.size() == 0)
			return;
		Bulk.Builder bulk = new Bulk.Builder().defaultIndex(index).defaultType(type);
		for (Map.Entry<String, Map<String, Object>> payloadsEntry : payloads.entrySet()) {
			bulk.addAction(new Index.Builder(payloadsEntry.getValue()).id(payloadsEntry.getKey()).build());
		}
		JestResult doc = client.execute(bulk.build());
		System.out.println(doc.getJsonString());
	}

	public boolean indexExists(String index) throws IOException {
		return client.execute(new IndicesExists.Builder(index).build()).isSucceeded();
	}

	public void createIndex(String index) throws IOException {
		client.execute(new CreateIndex.Builder(index).build());
	}

	public String search(String index, String type, String query) throws IOException {
		Search.Builder searchBuilder = new Search.Builder(query).addIndex(index).addType(type);
		SearchResult result = client.execute(searchBuilder.build());
		Gson gson = new Gson();
		return gson.toJson(result.getJsonObject());
	}

	public static void main(String[] args) {

	}

	public void close() throws IOException {
		this.client.shutdownClient();
	}
}
