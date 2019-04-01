package com.sagar.iqs.cassandra.sparkjobs;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import com.datastax.spark.connector.japi.CassandraJavaUtil;
import com.datastax.spark.connector.japi.CassandraRow;
import com.datastax.spark.connector.japi.rdd.CassandraTableScanJavaRDD;
import com.sagar.training.cassandra.executors.Product;

public class JavaSparkJobRef {

	public static void main(String args[]) {
		SparkConf conf = new SparkConf();
		conf.setAppName("My application");
	    conf.setMaster("local[*]");
		conf.set("spark.cassandra.connection.host", "127.0.0.1");
		conf.set("spark.cassandra.connection.port", "9042");
		
		//SparkContext sc = new SparkContext(conf);
		
		JavaSparkContext jsc = new JavaSparkContext(conf);
		
		CassandraTableScanJavaRDD<CassandraRow> rdd =
			    CassandraJavaUtil
			        .javaFunctions(jsc)
			        .cassandraTable("myks", "product");
		
		JavaRDD<Product> pojoRdd = rdd.map(
			    new Function<CassandraRow, Product>() {
			    	@Override
			        public Product call(CassandraRow row) {
			            return someMethodThatConvertsRowsToPojos(row);
			        }

					private Product someMethodThatConvertsRowsToPojos(CassandraRow row) {
						Product product = new Product(row.getInt(0), row.getString(2), row.getString(1), row.getInt(3));
						return product;
					}
			    }
			);
		
		pojoRdd.foreach(product -> System.out.println(product.getId()+":"+product.getName()));
		
		jsc.stop();
			
	}
}
