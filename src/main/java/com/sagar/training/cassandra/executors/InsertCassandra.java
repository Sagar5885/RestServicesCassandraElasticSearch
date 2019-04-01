package com.sagar.training.cassandra.executors;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class InsertCassandra {
	
	private static Cluster cluster;
	private static Session session;
	
	public static Cluster connect(String node) {
		return cluster.builder().addContactPoint(node).build();
	}

	public static void main(String args[]) {
		cluster = connect("localhost");
		session = cluster.connect();
				
//		session.execute("insert into myks.product (id, name, description, price) values (1, 'iphone', 'mac os', 1000);");
//		session.execute("insert into myks.product (id, name, description, price) values (2, 'mac book pro', 'mac os', 2000);");
//		session.execute("update myks.product set price = 1100 where id = 1;");
//		session.execute("update myks.product set price = 2200, name = 'mac book pro II' where id = 2;");
		session.execute("insert into myks.product (id, name, description, price) values (3, 'ipad', 'mac os', 800);");
		
		session.close();
		cluster.close();
	}
}
