package bigdata3.web.json;

import static bigdata3.web.json.JsonResult.STATE_FAIL;
import static bigdata3.web.json.JsonResult.STATE_SUCCESS;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bigdata3.domain.Teacher;
import bigdata3.service.FileUploadService;
import bigdata3.service.TeacherService;

@RestController("json.TeacherControl")
@RequestMapping("/teacher/json")
public class TeacherControl {
  
  @Autowired TeacherService teacherService;
  @Autowired ServletContext servletContext;
  @Autowired FileUploadService fileUploadService;
  
  @RequestMapping("add")
  public Object add(
      Teacher teacher, 
      MultipartFile[] photo) throws Exception {
    try {
      ArrayList<String> photoList = new ArrayList<>();
      for (MultipartFile fileItem : photo) {
        String filename = fileUploadService.save(fileItem);
        if (filename == null) continue;
        photoList.add(filename);
      }
      teacher.setPhotoList(photoList);
      teacherService.add(teacher);
      return new JsonResult(STATE_SUCCESS, null);
      
    } catch (Exception e) {
      return new JsonResult(STATE_FAIL, e.getMessage());
    }
  }
  
  @RequestMapping("delete")
  public Object delete(int no) throws Exception {
    try {
      teacherService.remove(no);
      return new JsonResult(STATE_SUCCESS, null);
      
    } catch (Exception e) {
      return new JsonResult(STATE_FAIL, e.getMessage());
    }
  }  

  @RequestMapping("detail")
  public Object detail(int no) throws Exception {
    try {
      Teacher teacher = teacherService.get(no);
      if (teacher == null) {
        throw new Exception(no + "번 강사가 없습니다.");
      }
      return new JsonResult(STATE_SUCCESS, teacher);
      
    } catch (Exception e) {
      return new JsonResult(STATE_FAIL, e.getMessage());
    }
  }

  @RequestMapping("list")
  public Object list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="5") int pageSize) throws Exception {
    try {
      return new JsonResult(STATE_SUCCESS, 
                          teacherService.list(pageNo, pageSize));
    } catch (Exception e) {
      return new JsonResult(STATE_FAIL, e.getMessage());
    }
  }
  
  @RequestMapping("update")
  public Object update(
      Teacher teacher, 
      MultipartFile[] photo) throws Exception {
    try {
      ArrayList<String> photoList = new ArrayList<>();
      for (MultipartFile fileItem : photo) {
        String filename = fileUploadService.save(fileItem);
        if (filename == null) continue;
        photoList.add(filename);
      }
      teacher.setPhotoList(photoList); // 업로드 한 사진 파일명을 저장한다.
      teacherService.update(teacher);
      return new JsonResult(STATE_SUCCESS, null);
      
    } catch (Exception e) {
      return new JsonResult(STATE_FAIL, e.getMessage());
    }
  }
}









