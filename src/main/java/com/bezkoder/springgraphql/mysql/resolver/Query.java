package com.bezkoder.springgraphql.mysql.resolver;

import com.bezkoder.springgraphql.mysql.model.*;
import com.bezkoder.springgraphql.mysql.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Query implements GraphQLQueryResolver {
	private FamilyRepository familyRepository;
	private OrganizationRepository organizationRepository;
	private LiveTradeLevelsRepository liveTradeLevelsRepository;
	private UserInfoRepository userInfoRepository;
	private AlertAccountRepository alertAccountRepository;
	private TradesuitePtaRepository tradesuitePtaRepository;
	private LiveTradeDetailsRepository liveTradeDetailsRepository;
	private LocationRepository locationRepository;

	@Autowired
	public Query(FamilyRepository familyRepository,
				 OrganizationRepository organizationRepository,
				 LiveTradeLevelsRepository liveTradeLevelsRepository,
				 UserInfoRepository userInfoRepository,
				 AlertAccountRepository alertAccountRepository,
				 TradesuitePtaRepository tradesuitePtaRepository,
				 LiveTradeDetailsRepository liveTradeDetailsRepository,
				 LocationRepository locationRepository) {
		this.familyRepository = familyRepository;
		this.organizationRepository = organizationRepository;
		this.liveTradeLevelsRepository = liveTradeLevelsRepository;
		this.userInfoRepository = userInfoRepository;
		this.alertAccountRepository = alertAccountRepository;
		this.tradesuitePtaRepository = tradesuitePtaRepository;
		this.liveTradeDetailsRepository = liveTradeDetailsRepository;
		this.locationRepository = locationRepository;
	}

//	public Iterable<Family> findAllFamilies() {
//		return familyRepository.findAll();
//	}


	public Family findFamilyById(Long id) {
		return familyRepository.findByFamilyId(id);
	}

	public Organization findOrganizationById(Long id){
		return organizationRepository.findOrganizationByOrgId(id);
	}

	public List<LiveTradeLevels> findTradesBySecurityTypeAndXrefTypeAndXrefValue(
			String securityCodeType, String orgXrefType, String orgXrefValue){
		Organization organization =
				organizationRepository.findByOrganizationXrefOrgXrefTypeAndOrganizationXrefOrgXrefValue(orgXrefType, orgXrefValue);
		System.out.println(organization.getOrgId());
		return liveTradeLevelsRepository.findByInstructingPartyOrgIdAndSecurityTypeLpCode(organization.getOrgId(), securityCodeType);
	}

	public List<LiveTradeLevels> findTradesBySecurityTypeLp(String code){
		return liveTradeLevelsRepository.findBySecurityTypeLpCode(code);
	}

	public List<LiveTradeLevels> findTradesByPoliticalSubdivision(String subdivision){
		List<Organization> organizations =
				organizationRepository.findByLocationsPoliticalSubdivision(subdivision);
		return liveTradeLevelsRepository.findByInstructingPartyIn(organizations);
	}

	public List<UserInfo> findUserInfoByPoliticalSubdivisionAndRoleName(String subdivision,
																		String roleName){
		return userInfoRepository.findByLocationsPoliticalSubdivisionAndRolesRoleName(subdivision
				, roleName);
	}

	public List<AlertAccount> findOrganizationsByPoliticalSubdivisionAndAlert(String subdivision){
		List<Organization> organizations =
				organizationRepository.findByLocationsPoliticalSubdivision(subdivision);
		return alertAccountRepository.findByOrganizationIn(organizations);
	}

	public TradesuitePta findTradesuitePtaByDtccControlNum(Long dtccControlNum){
		return tradesuitePtaRepository.findTradesuitePtaByDtccControlNum(dtccControlNum);
	}
	 public List<LiveTradeDetails> findLiveTradeDetailsByTradeDetailId(Long tradeDetailId){
		 return liveTradeDetailsRepository.findLiveTradeDetailsByTradeDetailId(tradeDetailId);
	}

	public List<TradesuitePta> findTradesuitePtasInTsByPoliticalSubdivision(String politicalSubdivision){
		List<Organization> organizations = organizationRepository.findByLocationsPoliticalSubdivision(politicalSubdivision);
		List<TradesuitePta> tradesuitePtas = tradesuitePtaRepository.findByOrganizationIn(organizations);
		return tradesuitePtas;
	}

//	public List<LiveTradeDetails> findLiveTradeDetailsByPoliticalSubdivisionAndOrganization(String politicalSubdivision, Long OrgId){
//		return liveTradeLevelsRepository
//	}

}