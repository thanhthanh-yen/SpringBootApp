package miniProject.service.Impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import miniProject.exception.StorageException;
import miniProject.service.StorageService;
import miniProject.storage.StorageProperties;

@Service
public class StorageServiceImpl implements StorageService {

	private final Path fileStorageLocation;

	@Autowired
	public StorageServiceImpl(StorageProperties storageProperties) {
		// TODO Auto-generated constructor stub
		this.fileStorageLocation = Paths.get(storageProperties.getLocation());
	}

	@Override
	@PostConstruct
	public void init() {
		// TODO Auto-generated method stubs

		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			// throw new FileStorageException("Could not create the directory where the
			// uploaded files will be stored.", ex);
			throw new StorageException("Could not initialize storage location", ex);
		}

	}

	@Override
	public String store(MultipartFile file) {
		// TODO Auto-generated method stub
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if (file.isEmpty()) {
				throw new StorageException("Failed to store empty file " + fileName);
			}
			// Copy file to the target location (Replacing existing file with the same name)
			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

		} catch (IOException ex) {
			// throw new FileStorageException("Could not store file " + fileName + ". Please
			// try again!", ex);
			throw new StorageException("Failed to store file " + fileName, ex);
		}
		return fileName;
	}

}
