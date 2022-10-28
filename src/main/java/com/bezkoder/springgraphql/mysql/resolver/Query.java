package com.bezkoder.springgraphql.mysql.resolver;

import com.bezkoder.springgraphql.mysql.model.Author;
import com.bezkoder.springgraphql.mysql.model.Organization;
import com.bezkoder.springgraphql.mysql.model.Tutorial;
import com.bezkoder.springgraphql.mysql.repository.AuthorRepository;
import com.bezkoder.springgraphql.mysql.repository.OrganizationRepository;
import com.bezkoder.springgraphql.mysql.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bezkoder.springgraphql.mysql.model.Family;
import com.bezkoder.springgraphql.mysql.repository.FamilyRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
	private FamilyRepository familyRepository;
	private AuthorRepository authorRepository;
	private TutorialRepository tutorialRepository;
	private OrganizationRepository organizationRepository;

	@Autowired
	public Query(AuthorRepository authorRepository,
				 TutorialRepository tutorialRepository,
				 FamilyRepository familyRepository,
				 OrganizationRepository organizationRepository) {
		this.authorRepository = authorRepository;
		this.tutorialRepository = tutorialRepository;
		this.familyRepository = familyRepository;
		this.organizationRepository = organizationRepository;
	}

	public Iterable<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

	public Iterable<Tutorial> findAllTutorials() {
		return tutorialRepository.findAll();
	}

	public long countAuthors() {
		return authorRepository.count();
	}

	public long countTutorials() {
		return tutorialRepository.count();
	}

	public Iterable<Family> findAllFamilies() {
		return familyRepository.findAll();
	}

	public Optional<Family> findFamilyById(Long id) {
		return familyRepository.findById(id);
	}

	public Iterable<Organization> findAllOrganizations(){
		return organizationRepository.findAll();
	}

	public Optional<Organization> findOrganizationById(Long id){
		return organizationRepository.findById(id);
	}
}