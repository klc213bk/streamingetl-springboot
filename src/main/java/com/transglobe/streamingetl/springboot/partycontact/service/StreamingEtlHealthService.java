package com.transglobe.streamingetl.springboot.partycontact.service;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transglobe.streamingetl.springboot.partycontact.model.StreamingEtlHealth;
import com.transglobe.streamingetl.springboot.partycontact.model.UpTime;
import com.transglobe.streamingetl.springboot.partycontact.repository.StreamingEtlHealthRepository;


@Service
public class StreamingEtlHealthService {
	static final Logger logger = LoggerFactory.getLogger(StreamingEtlHealthService.class);
	
	@Autowired
	private StreamingEtlHealthRepository streamingEtlHealthRepository;
	
	public UpTime getUpTime() throws Exception{
		StreamingEtlHealth health1st = streamingEtlHealthRepository.get1stRecord();
		StreamingEtlHealth healthLast = streamingEtlHealthRepository.getLastRecord();
		
		
		Duration duration = Duration.between(health1st.getConsumerTime().toLocalDateTime(), healthLast.getConsumerTime().toLocalDateTime());
			
		UpTime upTime = new UpTime();
		upTime.setStartTime(health1st.getConsumerTime().toString());
		upTime.setLastTime(healthLast.getConsumerTime().toString());
		upTime.setDuration(duration.toString());
		
		return upTime;
	}
	
	public List<StreamingEtlHealth> getHealthRecordsAfter(Long millis) {
		return streamingEtlHealthRepository.getHealthRecordsAfter(millis);
	}
}
