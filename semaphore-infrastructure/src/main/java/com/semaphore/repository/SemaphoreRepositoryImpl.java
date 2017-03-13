package com.semaphore.repository;

import org.springframework.stereotype.Service;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.utils.UUIDs;
import com.semaphore.model.Semaphore;

@Service
public class SemaphoreRepositoryImpl implements SemaphoreReposistory {

	private Session session;
	
	public SemaphoreRepositoryImpl(){
		final Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		session = cluster.connect();
	}
	
	public void save(Semaphore semaphore) {
		Insert insert = QueryBuilder.insertInto("SemaphoreKeySpace", "Semaphore")
									.value("id", UUIDs.timeBased())
									.value("activedLight", semaphore.getActivedLight());
		
		session.execute(insert);
	}

	public void update(Semaphore semaphore){
		
		Statement update = QueryBuilder.update("SemaphoreKeySpace", "Semaphore").with(QueryBuilder.set("activedLight", semaphore.getActivedLight()));
		
		session.execute(update);
		
	}

	public Semaphore getById(int id) {
		
		Statement select = QueryBuilder.select().from("SemaphoreKeySpace", "Semaphore").where(QueryBuilder.gt("key",id));
		
		ResultSet resultSet = session.execute(select);
		
		return createSemaphore(resultSet.one());
	}
	
	private Semaphore createSemaphore(Row row){
		
		return new Semaphore(row.getInt("id"), row.getString("activedLight"));
	
	}
}
