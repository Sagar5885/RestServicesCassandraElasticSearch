package com.sagar.training.cassandra.executors;

import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

public class GetFindCassandra {
	
	private static Cluster cluster;
	private static Session session;
	
	public static Cluster connect(String node) {
		return Cluster.builder().addContactPoint(node).build();
	}
	
	public static void main(String args[]) {
		cluster = connect("localhost");
		session = cluster.connect();
		
		ResultSet rs = session.execute("select * from myks.product");
		List<Product> productList = new ArrayList<>();
		rs.forEach(r -> {
			productList.add(new Product(
					r.getInt("id"),
					r.getString("name"),
					r.getString("description"),
					r.getInt("price")));
		});
		
		for (Product product : productList) {
			System.out.println(product.getId());
			System.out.println(product.getName());
			System.out.println(product.getDescription());
			System.out.println(product.getPrice());
		}
		
		session.close();
		cluster.close();
	}

}
