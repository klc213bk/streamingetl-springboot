package com.transglobe.streamingetl.springboot.partycontact.model;

import java.sql.Timestamp;
public class StreamingEtlHealth {
	
	private long id;
	
	private Timestamp cdcTime;
	
	private String logminerId;
	
	private Timestamp logminerTime;
	
	private String consumerId;
	
	private Timestamp consumerTime;

	public StreamingEtlHealth(Long id, Timestamp cdcTime, String logminerId,
			Timestamp logminerTime, String consumerId, Timestamp consumerTime) {
		this.id = id;
		this.cdcTime = cdcTime;
		this.logminerId = logminerId;
		this.logminerTime = logminerTime;
		this.consumerId = consumerId;
		this.consumerTime = consumerTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getCdcTime() {
		return cdcTime;
	}

	public void setCdcTime(Timestamp cdcTime) {
		this.cdcTime = cdcTime;
	}

	public String getLogminerId() {
		return logminerId;
	}

	public void setLogminerId(String logminerId) {
		this.logminerId = logminerId;
	}

	public Timestamp getLogminerTime() {
		return logminerTime;
	}

	public void setLogminerTime(Timestamp logminerTime) {
		this.logminerTime = logminerTime;
	}

	public String getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	public Timestamp getConsumerTime() {
		return consumerTime;
	}

	public void setConsumerTime(Timestamp consumerTime) {
		this.consumerTime = consumerTime;
	}
	
}
