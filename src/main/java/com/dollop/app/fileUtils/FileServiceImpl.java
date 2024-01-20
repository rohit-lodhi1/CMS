package com.dollop.app.fileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.ProjectFiles;

@Service
public class FileServiceImpl implements FileService{

	@Value("${imagepath.file.path}")
	private String globalImagesPath  ;
	@Override
	public String uploadFileInFolder(MultipartFile file, String destinationPath) {
//	    String currentDir = System.getProperty("user.dir") + destinationPath;
//	    String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
//	    String randomId = UUID.randomUUID().toString();
//	    String randomName = randomId.concat(originalFilename.substring(originalFilename.lastIndexOf(".")));
//	    String filePath = currentDir + randomName;
//System.err.println(randomName+"     "+currentDir +"      "+filePath);
	 
				
				  String originalFilename = file.getOriginalFilename();
				
		String	fileName=	 (UUID.randomUUID().toString()+originalFilename);
				 
				
					Path path = Paths.get(System.getProperty("user.dir")+destinationPath, fileName);
					System.err.println(path);
		// Check the file extension to determine the file type
	    String fileExtension = getFileExtension(originalFilename);

	    // Define the list of supported file extensions (PDF, image formats, etc.)
	    String[] supportedExtensions = {"pdf", "jpg", "jpeg", "png", "gif", "bmp"};

	    // Check if the file extension is in the list of supported extensions
	    boolean isSupportedExtension = false;
	    for (String ext : supportedExtensions) {
	        if (ext.equalsIgnoreCase(fileExtension)) {
	            isSupportedExtension = true;
	            break;
	        }
	    }

	    if (!isSupportedExtension) {
	        return null; // Return null for unsupported file types
	    }

	    try {
//	        File destinationFile = new File(filePath);
//	        FileUtils.forceMkdirParent(destinationFile);
//	        file.transferTo(destinationFile);
//	        return randomName;
	    	Files.copy(file.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
			return fileName;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }

	}

	@Override
	public List<String> uploadFileInFolder(List<MultipartFile> file, String destinationPath) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public InputStream getImages(String fileName,String destination){
		//System.out.println(System.getProperty("user.dir")+globalImagesPath+destination+File.separator+fileName);
		try {
				return new FileInputStream(System.getProperty("user.dir")+globalImagesPath+destination+File.separator+fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	private String getFileExtension(String filename) {
	    int lastDotIndex = filename.lastIndexOf(".");
	    if (lastDotIndex >= 0) {
	        return filename.substring(lastDotIndex + 1).toLowerCase();
	    }
	    return "";
	}

}
