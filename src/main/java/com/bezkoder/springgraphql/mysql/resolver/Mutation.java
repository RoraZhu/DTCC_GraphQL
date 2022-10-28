package com.bezkoder.springgraphql.mysql.resolver;

import java.util.Optional;

import com.bezkoder.springgraphql.mysql.model.Family;
import com.bezkoder.springgraphql.mysql.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bezkoder.springgraphql.mysql.model.Author;
import com.bezkoder.springgraphql.mysql.model.Tutorial;
import com.bezkoder.springgraphql.mysql.repository.AuthorRepository;
import com.bezkoder.springgraphql.mysql.repository.TutorialRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import javassist.NotFoundException;

@Component
public class Mutation implements GraphQLMutationResolver {
	private AuthorRepository authorRepository;
	private TutorialRepository tutorialRepository;
	private FamilyRepository familyRepository;

	@Autowired
	public Mutation(AuthorRepository authorRepository,
					TutorialRepository tutorialRepository,
					FamilyRepository familyRepository) {
		this.authorRepository = authorRepository;
		this.tutorialRepository = tutorialRepository;
		this.familyRepository = familyRepository;
	}

	public Author createAuthor(String name, Integer age) {
		Author author = new Author();
		author.setName(name);
		author.setAge(age);

		authorRepository.save(author);

		return author;
	}

	public Tutorial createTutorial(String title, String description, Long authorId) {
		Tutorial book = new Tutorial();
		book.setAuthor(new Author(authorId));
		book.setTitle(title);
		book.setDescription(description);

		tutorialRepository.save(book);

		return book;
	}

	public Family createFamily(Long id, String family_name, String family_description) {
		Family family = new Family();
		family.setFamilyId(id);
		family.setFamilyName(family_name);
		family.setFamilyDescription(family_description);

		familyRepository.save(family);

		return family;
	}

	public boolean deleteFamily(Long id){
		familyRepository.deleteById(id);
		return true;
	}

	public boolean deleteTutorial(Long id) {
		tutorialRepository.deleteById(id);
		return true;
	}

	public Tutorial updateTutorial(Long id, String title, String description) throws NotFoundException {
		Optional<Tutorial> optTutorial = tutorialRepository.findById(id);

		if (optTutorial.isPresent()) {
			Tutorial tutorial = optTutorial.get();

			if (title != null)
				tutorial.setTitle(title);
			if (description != null)
				tutorial.setDescription(description);

			tutorialRepository.save(tutorial);
			return tutorial;
		}

		throw new NotFoundException("Not found Tutorial to update!");
	}

	public Family updateFamily(Long id, String name, String description) throws NotFoundException{
		Optional<Family> optFamily = familyRepository.findById(id);

		if (optFamily.isPresent()){
			Family family = optFamily.get();

			if (name != null){
				family.setFamilyName(name);
			}
			if (description != null){
				family.setFamilyDescription(description);
			}

			familyRepository.save(family);
			return family;
		}

		throw new NotFoundException("Not found Family to update!");
	}
}
