package com.projectvilla.villabooking.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

	void init();

	void store(MultipartFile file);

	String storeFile(MultipartFile file);

	Stream<Path> loadAll();

	Path load(String filename);



	void deleteAll();

    Resource loadFileAsResource(String fileName);

}