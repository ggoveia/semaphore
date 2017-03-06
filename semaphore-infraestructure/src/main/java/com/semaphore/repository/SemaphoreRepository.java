package com.semaphore.repository;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select.Where;
import com.datastax.driver.core.querybuilder.Update.Assignments;
import com.datastax.driver.core.utils.UUIDs;

import com.semaphore.domain.Semaphore;

public class SemaphoreRepository {

private Session session;
	
	public SemaphoreRepository(){
		final Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		session = cluster.connect();
	}
	
	public void save(Semaphore semaphore) {
		Insert insert = QueryBuilder.insertInto("SemaphoreKeySpace", "Semaphore")
									.value("id", UUIDs.timeBased())
									.value("activedLight", semaphore.getLightOn());
		
		session.execute(insert);
	}
	
	public void update(Semaphore semaphore){
		
		Assignments update = QueryBuilder.update("SemaphoreKeySpace", "Semaphore").with(QueryBuilder.set("id", semaphore.getId()));
		
		session.execute(update);
		
	}
	public Semaphore getById(int id) {
		
		Where select = QueryBuilder.select().from("SemaphoreKeySpace", "Semaphore").where(QueryBuilder.eq("key",id));
		
		ResultSet resultSet = session.execute(select);
		
		Semaphore semaphore = createSemaphoreFromRow(resultSet.one());
			
		return semaphore;
	}
	
	private Semaphore createSemaphoreFromRow(Row row){
		
		Semaphore semaphore = new Semaphore(row.getInt("id"), row.getString("activedLight"));
	
		return semaphore;
	}
}
