package com.sagar.training.cassandra;

import com.datastax.driver.core.Session;

public class KeyspaceRepository {
	
	public void createKeyspace(String keySpaceName, String replicationStrategy, int replicationFactor, Session session) {
		StringBuilder sb = new StringBuilder("CREATE KEYSPACE IF NOT EXISTS ")
				.append(keySpaceName).append(" WITH replication = {")
				.append("'class':'").append(replicationStrategy)
				.append("','replication_factor':").append(replicationFactor)
				.append("};");
		
		String query = sb.toString();
		session.execute(query);
	}
}
