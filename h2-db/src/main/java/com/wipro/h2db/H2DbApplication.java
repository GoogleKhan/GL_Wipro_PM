package com.wipro.h2db;

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

		log.info("fetch  Libraries paged -> {}",
				readLibraryService.getLibrariesPaged().get().collect(Collectors.toList()));

		log.info("fetch  Libraries paged custom on Page 1-> {}",
				readLibraryService.getLibrariesCustomPaged(0, 2).get().collect(Collectors.toList()));

		log.info("fetch  Libraries paged custom on page 2-> {}",
				readLibraryService.getLibrariesCustomPaged(1, 2).get().collect(Collectors.toList()));

		log.info("fetch  Libraries With Latest Added Order-> {}",
				readLibraryService.getLibrariesWithLatestAddedOrder());

		log.info("fetch  Libraries Custom Sorted By Id -> {}",
				readLibraryService.getLibrariesCustomSortedById(Direction.ASC));

		log.info("fetch  Libraries Custom Sorted By Name -> {}",
				readLibraryService.getLibrariesCustomSortedByName(Direction.ASC));

	}

}
