package com.sagar.iqs.cassandra.sparkjobs;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

public class CassandraConnTest1 {
	
	private static Cluster cluster;
	private static Session session;
	
	public static Cluster connect(String node) {
		return Cluster.builder().addContactPoint(node).build();
	}
	
	public static void main(String args[]) {
	
		cluster = connect("host");
		session = cluster.connect();
		
		session.execute("use limo");
		ResultSet rs = session.execute("select column from table limit 10");
		
		rs.forEach(r -> System.out.println(r));
		
		session.close();
		cluster.close();
	}
}
