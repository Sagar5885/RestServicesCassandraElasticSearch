package com.sagar.training.cassandra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

public class KeySpaceCreationTest {

	private KeyspaceRepository schemaRepository;
	private Session session;
	
	@Before
	public void connect() {
	    CassandraConnector client = new CassandraConnector();
	    client.connect("127.0.0.1", 9042);
	    this.session = client.getSession();
	}
	
	@Test
	public void whenCreatingAKeyspace_thenCreated() {
	    String keyspaceName = "library";
	    schemaRepository.createKeyspace(keyspaceName, "SimpleStrategy", 1, session);
	 
	    ResultSet result = 
	      session.execute("SELECT * FROM system_schema.keyspaces;");
	 
	    List<String> matchedKeyspaces = result.all()
	      .stream()
	      .filter(r -> r.getString(0).equals(keyspaceName.toLowerCase()))
	      .map(r -> r.getString(0))
	      .collect(Collectors.toList());
	 
	    assertEquals(matchedKeyspaces.size(), 1);
	    assertTrue(matchedKeyspaces.get(0).equals(keyspaceName.toLowerCase()));
	}
	
}
