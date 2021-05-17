package com.transglobe.streamingetl.springboot.partycontact.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.transglobe.streamingetl.springboot.partycontact.model.PartyContact;


@Repository
public class JdbcPartyContactRepository implements PartyContactRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<PartyContact> findByEmail(String email) {
		return jdbcTemplate.query(
                "select * from T_PARTY_CONTACT where EMAIL='" + email + "'",
                (rs, rowNum) ->
                        new PartyContact(
                        		rs.getInt("ROLE_TYPE"), rs.getLong("LIST_ID"), rs.getLong("POLICY_ID"), 
                        		rs.getString("NAME"), rs.getString("CERTI_CODE"), rs.getString("MOBILE_TEL")
                        				, rs.getString("EMAIL"), rs.getLong("ADDRESS_ID"), rs.getString("ADDRESS_1")

                        )
        );
	}
	
	@Override
	public List<PartyContact> findByMobileTel(String mobileTel) {
		return jdbcTemplate.query(
                "select * from T_PARTY_CONTACT where MOBILE_TEL='" + mobileTel + "'",
                (rs, rowNum) ->
                        new PartyContact(
                        		rs.getInt("ROLE_TYPE"), rs.getLong("LIST_ID"), rs.getLong("POLICY_ID"), 
                        		rs.getString("NAME"), rs.getString("CERTI_CODE"), rs.getString("MOBILE_TEL")
                        				, rs.getString("EMAIL"), rs.getLong("ADDRESS_ID"), rs.getString("ADDRESS_1")

                        )
        );
	}

	@Override
	public List<PartyContact> findByAddress(String address) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("address", "%" + address + "%");

        return namedParameterJdbcTemplate.query(
                "select * from T_PARTY_CONTACT where ADDRESS_1 like :address",
                mapSqlParameterSource,
                (rs, rowNum) ->
                new PartyContact(
                		rs.getInt("ROLE_TYPE"), rs.getLong("LIST_ID"), rs.getLong("POLICY_ID"), 
                		rs.getString("NAME"), rs.getString("CERTI_CODE"), rs.getString("MOBILE_TEL")
                				, rs.getString("EMAIL"), rs.getLong("ADDRESS_ID"), rs.getString("ADDRESS_1")

                )
        );
	}


}
