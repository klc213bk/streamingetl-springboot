package com.transglobe.streamingetl.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.transglobe.streamingetl.springboot.repository.PartyContactRepository;

@Service
public class PartyContactService {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@Autowired
    //@Qualifier("jdbcBookRepository")              // Test JdbcTemplate
  //  @Qualifier("namedParameterJdbcBookRepository")  // Test NamedParameterJdbcTemplate
    private PartyContactRepository partyContactRepository;
	
	public List<PartyContact> getPartyContactsByEmail(String email){
		return partyContactRepository.findByEmail(email);
	}
	
	public List<PartyContact> getPartyContactsByAddress(String address){
		return partyContactRepository.findByAddress(address);
	}
	
	public List<PartyContact> getPartyContactsByMobileTel(String mobileTel){
		return partyContactRepository.findByMobileTel(mobileTel);
	}
	
}
