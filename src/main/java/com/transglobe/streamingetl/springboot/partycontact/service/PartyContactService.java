package com.transglobe.streamingetl.springboot.partycontact.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.transglobe.streamingetl.springboot.partycontact.model.PartyContact;
import com.transglobe.streamingetl.springboot.partycontact.model.StreamingEtlHealth;
import com.transglobe.streamingetl.springboot.partycontact.model.UpTime;
import com.transglobe.streamingetl.springboot.partycontact.repository.PartyContactRepository;
import com.transglobe.streamingetl.springboot.partycontact.repository.StreamingEtlHealthRepository;

@Service
public class PartyContactService {
	static final Logger logger = LoggerFactory.getLogger(PartyContactService.class);
	
//	@Autowired
//    JdbcTemplate jdbcTemplate;
//	
	@Autowired
    //@Qualifier("jdbcBookRepository")              // Test JdbcTemplate
  //  @Qualifier("namedParameterJdbcBookRepository")  // Test NamedParameterJdbcTemplate
    private PartyContactRepository partyContactRepository;
	

	
	public List<PartyContact> getPartyContactsByEmail(String email){
		return partyContactRepository.findByEmail(email);
	}
	
	public List<PartyContact> getPartyContactsByAddress1(String address1){
		return partyContactRepository.findByAddress1(address1);
	}
	
	public List<PartyContact> getPartyContactsByMobileTel(String mobileTel){
		return partyContactRepository.findByMobileTel(mobileTel);
	}
	
	public List<PartyContact> getPartyContactsByListId(Long listId){
		return partyContactRepository.findByListId(listId);
	}
	
	public List<PartyContact> getPartyContactsByCertiCode(String certiCode){
		return partyContactRepository.findByCertiCode(certiCode);
	}
	
	public List<PartyContact> getPartyContactsByAddressId(Long addressId){
		return partyContactRepository.findByAddressId(addressId);
	}
	

}
