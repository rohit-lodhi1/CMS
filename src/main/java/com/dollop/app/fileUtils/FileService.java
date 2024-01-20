package com.dollop.app.fileUtils;

import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	public String uploadFileInFolder(MultipartFile file, String destinationPath);

	public List<String> uploadFileInFolder(List<MultipartFile> file, String destinationPath);

	public InputStream getImages(String fileName, String destination);
}
