package com.sagar.training.cassandra.executors;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CassConnector {

	private static Cluster cluster;
	private static Session session;
	
	public static Cluster connect(String node) {
		return Cluster.builder().addContactPoint(node).build();
	}
	
	public static void main(String args[]) {
		cluster = connect("localhost");
		session = cluster.connect();
		
		System.out.println("This Key Space and Table Already Created So Uncomment and update those info before run!");
		
//		session.execute("CREATE KEYSPACE myks WITH REPLICATION = "+"{ 'class' : 'SimpleStrategy', 'replication_factor' : 1};");
//		
//		session.execute("USE myks");
//		
//		session.execute("CREATE TABLE IF NOT EXISTS Product (\n" + 
//				"  id int PRIMARY KEY,\n" + 
//				"  name text,\n" + 
//				"  description text,\n" + 
//				"  price int,\n" + 
//				");");
		
		session.close();
		cluster.close();
	}
	
}
