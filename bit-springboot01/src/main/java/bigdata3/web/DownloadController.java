package bigdata3.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bigdata3.service.FileUploadService;

@Controller
public class DownloadController {
  @Autowired FileUploadService fileUploadService;
  
  @RequestMapping("/download/{filename}")
  public ResponseEntity<Resource> download(@PathVariable String filename) throws Exception {
    // 클라이언트 요청에 대해 파일을 찾아 리턴하려 한다.
    // 다음 절차에 따라 클라이언트에게 리턴하라!
    
    // 0) 클라이언트가 요청한 파일을 꺼낸다.
    // => load()가 리턴하는 것은 파일을 읽어주는 도구이다. 
    // => 즉 Resource가 파일을 읽어주는 도구이다.
    Resource file = fileUploadService.load(filename);
    
    // 1) HTTP 응답 내용을 만들어주는 도구를 준비한다.
    BodyBuilder bodyBuilder = ResponseEntity.ok();
    
    // 2) 클라이언트에게 파일을 보낼 것이기 때문에 그에 맞는 응답헤더를 추가한다.
    // => 클라이언트에게 보내는 콘텐츠의 성질(성향,기질)을 응답 헤더를 통해 브라우저에게 전달.
    bodyBuilder.header(HttpHeaders.CONTENT_DISPOSITION, 
        "attachment: filename=\"" + filename + "\"");
    
    // 3) 도구를 사용하여 다운로드할 파일을 보낸다.
    return bodyBuilder.body(file);
  }
}






