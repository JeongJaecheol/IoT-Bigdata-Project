package bigdata3.service.impl;

import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import bigdata3.service.FileUploadService;

@Service
public class FileUploadServiceImpl implements FileUploadService {
  static final String UPLOAD_DIR = "c:/webupload/";
  static final String PREFIX = "file_";
  
  @Override
  public String save(MultipartFile file) throws Exception {
    if (file.isEmpty())
      return null;
    
    String newFilename = this.generateFilename();
    File savedFile = new File(UPLOAD_DIR + newFilename);
    file.transferTo(savedFile);
    
    return newFilename;
  }

  @Override
  public Resource load(String filename) throws Exception {
    return new FileSystemResource(UPLOAD_DIR + filename);
  }
  
  private int count = 0;
  private String generateFilename() {
    if (count > 1000) {
      count = 0;
    }
    return PREFIX + System.currentTimeMillis() + "_" + (++count);
  }

}








