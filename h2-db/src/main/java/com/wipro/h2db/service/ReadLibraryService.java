package com.wipro.h2db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.wipro.h2db.model.Library;
import com.wipro.h2db.repository.LibraryRepository;

@Service
public class ReadLibraryService {

	@Autowired
	private LibraryRepository libraryRepository;

	public List<Library> getAllLibraries() {
		return libraryRepository.findAll();
	}

	public List<Library> getAllLibrariesWithNoBooks() {

		Library library = new Library();
		library.setCommaSeparatedBookNames("");

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");

		Example<Library> example = Example.of(library, exampleMatcher);

		return libraryRepository.findAll(example);
	}

	public Page<Library> getLibrariesPaged() {

		Pageable pageable = PageRequest.of(0, 2);
		return libraryRepository.findAll(pageable);
	}

	public Page<Library> getLibrariesCustomPaged(int pageNum, int numOfRecordsOnPage) {

		Pageable pageable = PageRequest.of(pageNum, numOfRecordsOnPage);
		return libraryRepository.findAll(pageable);
	}

	public List<Library> getLibrariesWithLatestAddedOrder() {

		Sort sort = Sort.by(Direction.DESC, "id");

		return libraryRepository.findAll(sort);
	}

	public List<Library> getLibrariesCustomSortedById(Direction direction) {

		Sort sort = Sort.by(direction, "id");

		return libraryRepository.findAll(sort);
	}

	public List<Library> getLibrariesCustomSortedByName(Direction direction) {

		Sort sort = Sort.by(direction, "name");

		return libraryRepository.findAll(sort);
	}

	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBookNames) {

		Library library = new Library();
		library.setCommaSeparatedBookNames(commaSeparatedBookNames);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");

		Example<Library> example = Example.of(library, exampleMatcher);

		Sort sort = Sort.by("name");
		Pageable pageable = PageRequest.of(0, 2, sort);

		return libraryRepository.findAll(example, pageable);
	}

	public Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(
			String commaSeparatedBookNames, int pageNum, int numOfRecordsOnPage) {

		Library library = new Library();
		library.setCommaSeparatedBookNames(commaSeparatedBookNames);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");

		Example<Library> example = Example.of(library, exampleMatcher);

		Sort sort = Sort.by("name");
		Pageable pageable = PageRequest.of(pageNum, numOfRecordsOnPage, sort);

		return libraryRepository.findAll(example, pageable);
	}

	public Page<Library> getLibrariesPagedAndSortedByName(int pageNum, int numOfRecordsOnPage) {

		Sort sort = Sort.by("name");
		Pageable pageable = PageRequest.of(pageNum, numOfRecordsOnPage, sort);

		return libraryRepository.findAll(pageable);
	}

	public List<Library> getSortedByNameAndWithTheseBooks(String commaSeparatedBookNames) {

		Sort sort = Sort.by("name");

		Library library = new Library();
		library.setCommaSeparatedBookNames(commaSeparatedBookNames);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");

		Example<Library> example = Example.of(library, exampleMatcher);

		return libraryRepository.findAll(example, sort);
	}

	public List<Library> getLibrariesByIds(List<Long> ids) {
		return libraryRepository.findAllById(ids);
	}

	public List<Library> getAllLibraryWithTheseBooks(String commaSeparatedBookNames) {

		Library library = new Library();
		library.setCommaSeparatedBookNames(commaSeparatedBookNames);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");

		Example<Library> example = Example.of(library, exampleMatcher);

		return libraryRepository.findAll(example);
	}
}
