package com.transglobe.streamingetl.springboot.partycontact.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.transglobe.streamingetl.springboot.partycontact.model.PartyContact;
import com.transglobe.streamingetl.springboot.partycontact.model.StreamingEtlHealth;

@Repository
public class JdbcStreamingEtlHealthRepository implements StreamingEtlHealthRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public StreamingEtlHealth get1stRecord() {
		return jdbcTemplate.query(
                "select * from T_STREAMING_ETL_HEALTH order by CDC_TIME limit 1",
                (rs, rowNum) ->
                        new StreamingEtlHealth(
                        		rs.getLong("ID"), 
                        		rs.getTimestamp("CDC_TIME"), 
                        		rs.getString("LOGMINER_ID"), 
                        		rs.getTimestamp("LOGMINER_TIME"), 
                        		rs.getString("CONSUMER_ID"), 
                        		rs.getTimestamp("CONSUMER_TIME") 
                        		)
                        
        ).get(0);
	}
	@Override
	public StreamingEtlHealth getLastRecord() {
		return jdbcTemplate.query(
                "select * from T_STREAMING_ETL_HEALTH order by CDC_TIME desc limit 1",
                (rs, rowNum) ->
                        new StreamingEtlHealth(
                        		rs.getLong("ID"), 
                        		rs.getTimestamp("CDC_TIME"), 
                        		rs.getString("LOGMINER_ID"), 
                        		rs.getTimestamp("LOGMINER_TIME"), 
                        		rs.getString("CONSUMER_ID"), 
                        		rs.getTimestamp("CONSUMER_TIME") 
                        		)
                        
        ).get(0);
	}
	@Override
	public List<StreamingEtlHealth> getHealthRecordsAfter(long millis) {
		return jdbcTemplate.query(
                "select * from T_STREAMING_ETL_HEALTH where id > " + millis + " order by id desc",
                (rs, rowNum) ->
                        new StreamingEtlHealth(
                        		rs.getLong("ID"), 
                        		rs.getTimestamp("CDC_TIME"), 
                        		rs.getString("LOGMINER_ID"), 
                        		rs.getTimestamp("LOGMINER_TIME"), 
                        		rs.getString("CONSUMER_ID"), 
                        		rs.getTimestamp("CONSUMER_TIME") 
                        		)
                        
        );
	}
}
