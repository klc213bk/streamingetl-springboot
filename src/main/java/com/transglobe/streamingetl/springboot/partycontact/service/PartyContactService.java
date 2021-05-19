package com.transglobe.streamingetl.springboot.partycontact.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.transglobe.streamingetl.springboot.partycontact.model.PartyContact;
import com.transglobe.streamingetl.springboot.partycontact.repository.PartyContactRepository;

@Service
public class PartyContactService {
	static final Logger logger = LoggerFactory.getLogger(PartyContactService.class);
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@Autowired
    //@Qualifier("jdbcBookRepository")              // Test JdbcTemplate
  //  @Qualifier("namedParameterJdbcBookRepository")  // Test NamedParameterJdbcTemplate
    private PartyContactRepository partyContactRepository;
	
	public List<PartyContact> getPartyContactsByEmail(String email){
		logger.info(">>>>PartyContactService, search by email={}", email);
		return partyContactRepository.findByEmail(email);
	}
	
	public List<PartyContact> getPartyContactsByAddress(String address){
		logger.info(">>>>PartyContactService, search by address={}", address);
		return partyContactRepository.findByAddress(address);
	}
	
	public List<PartyContact> getPartyContactsByMobileTel(String mobileTel){
		logger.info(">>>>PartyContactService, search by mobileTel={}", mobileTel);
		return partyContactRepository.findByMobileTel(mobileTel);
	}
	
	public List<PartyContact> getPartyContactsByListId(Long listId){
		logger.info(">>>>PartyContactService, search by listId={}", listId);
		return partyContactRepository.findByListId(listId);
	}
	
	public List<PartyContact> getPartyContactsByCertiCode(String certiCode){
		logger.info(">>>>PartyContactService, search by certiCode={}", certiCode);
		return partyContactRepository.findByCertiCode(certiCode);
	}
	
	public List<PartyContact> getPartyContactsByAddressId(Long addressId){
		logger.info(">>>>PartyContactService, search by addressId={}", addressId);
		return partyContactRepository.findByAddressId(addressId);
	}
}
