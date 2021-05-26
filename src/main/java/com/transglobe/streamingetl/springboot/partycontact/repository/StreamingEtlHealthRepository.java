package com.transglobe.streamingetl.springboot.partycontact.repository;

import java.util.List;

import com.transglobe.streamingetl.springboot.partycontact.model.StreamingEtlHealth;

public interface StreamingEtlHealthRepository {

	StreamingEtlHealth get1stRecord();
	
	StreamingEtlHealth getLastRecord();
	
	List<StreamingEtlHealth> getHealthRecordsAfter(long millis);
}
