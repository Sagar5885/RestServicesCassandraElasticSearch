package com.sagar.training.cassandra.executors;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class DeleteCassandra {

	private static Cluster cluster;
	private static Session session;
	
	public static Cluster connect(String node) {
		return cluster.builder().addContactPoint(node).build();
	}
	
	public static void main(String args[]) {
		cluster = connect("localhost");
		session = cluster.connect();
		
		session.execute("delete from myks.product where id in (3)");
		
		session.close();
		cluster.close();
	}
}
