package com.sagar.training.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.core.Session;

public class CassandraConnector {
	
	private Cluster cluster;
	private Session session;

	public void connect(String node, Integer port) {
		Builder b = cluster.builder().addContactPoint(node);
		if(port != null) {
			b.withPort(port);
		}
		
		cluster = b.build();
		session = cluster.connect();
	}
	
	public Session getSession() {
		return this.session;
	}
	
	public void close() {
		session.close();
		cluster.close();
	}
}
