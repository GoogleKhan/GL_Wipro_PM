package com.wipro.h2db;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort.Direction;

import com.wipro.h2db.service.ReadLibraryService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class H2DbApplication implements CommandLineRunner {

	@Autowired
	private ReadLibraryService readLibraryService;

	public static void main(String[] args) {
		SpringApplication.run(H2DbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		log.info("fetch all Libraries -> {}", readLibraryService.getAllLibraries());

		log.info("fetch all Libraries with no books -> {}", readLibraryService.getAllLibrariesWithNoBooks());

		log.info("fetch All Libraries paged -> {}",
				readLibraryService.getLibrariesPaged().get().collect(Collectors.toList()));

		log.info("fetch All Libraries paged custom on Page 1-> {}",
				readLibraryService.getLibrariesCustomPaged(0, 2).get().collect(Collectors.toList()));

		log.info("fetch All Libraries paged custom on page 2-> {}",
				readLibraryService.getLibrariesCustomPaged(1, 2).get().collect(Collectors.toList()));

		log.info("fetch All Libraries With Latest Added Order-> {}",
				readLibraryService.getLibrariesWithLatestAddedOrder());

		log.info("fetch All Libraries Custom Sorted By Id -> {}",
				readLibraryService.getLibrariesCustomSortedById(Direction.ASC));

		log.info("fetch All Libraries Custom Sorted By Name -> {}",
				readLibraryService.getLibrariesCustomSortedByName(Direction.ASC));

		log.info("fetch All Libraries Paged And Sorted By Name And With These Books -> {}",
				readLibraryService.getLibrariesPagedAndSortedByNameAndWithTheseBooks("Book-A, Book-B, Book-C").get()
						.collect(Collectors.toList()));

		log.info("fetch All Libraries Custom Paged And Sorted With Default Order By Name And With These Books -> {}",
				readLibraryService.getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(
						"Book-A, Book-B, Book-C", 0, 2).get().collect(Collectors.toList()));

		log.info("fetch All Libraries Paged And Sorted By Name (0,2) -> {}",
				readLibraryService.getLibrariesPagedAndSortedByName(0, 2).get().collect(Collectors.toList()));

		log.info("fetch All Libraries Paged And Sorted By Name (1,2) -> {}",
				readLibraryService.getLibrariesPagedAndSortedByName(1, 2).get().collect(Collectors.toList()));

		log.info("fetch All Libraries Sorted By Name And With These Books -> {}",
				readLibraryService.getSortedByNameAndWithTheseBooks("Book-A, Book-B, Book-C"));

		List<Long> ids = List.of(3L, 4L, 6L);
		log.info("fetch All Libraries By Ids -> {}", readLibraryService.getLibrariesByIds(ids));

		log.info("fetch All Libraries With These Books -> {}",
				readLibraryService.getAllLibraryWithTheseBooks("Book-A, Book-B, Book-C"));

	}

}
