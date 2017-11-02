package bigdata3.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
  public String save(MultipartFile file) throws Exception;
  public Resource load(String filename) throws Exception;
}
