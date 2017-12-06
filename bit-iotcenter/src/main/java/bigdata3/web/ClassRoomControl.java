package bigdata3.web;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import bigdata3.domain.ClassRoom;
import bigdata3.service.ClassRoomService;

@Controller
@RequestMapping("/classroom")
public class ClassRoomControl {
  @Autowired ClassRoomService classRoomService;
  @Autowired ServletContext servletContext;
  
  @RequestMapping("list")
  public void list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="5") int pageSize,
      Model model) throws Exception {
    
    List<ClassRoom> list = classRoomService.list(pageNo, pageSize);
    model.addAttribute("list", list);
  }
  
  @RequestMapping("form")
  public void form() {
    // 페이지 컨트롤러에서 JSP 경로를 리턴하지 않으면
    // 프론트 컨트롤러는 요청 URL을 JSP 경로로 사용한다.
    // 예) http://localhost:8080/web01/classroom/form.do
    // 위 URL에서 서블릿 경로("/classroom/form")가 JSP URL이 된다.
    // 따라서 이 URL 앞에 접두사와 접미사가 붙으면 다음과 같이 된다.
    // => /WEB-INF/jsp/classroom/form.jsp
  }
  
  @RequestMapping("add")
  public String add(ClassRoom classRoom, MultipartFile[] photo) throws Exception {
    ArrayList<String> photoNameList = new ArrayList<>();
    for (MultipartFile fileItem : photo) {
      if (fileItem.getSize() == 0) continue;
      fileItem.transferTo(new File(servletContext.getRealPath(
          "/classroom/photo/" + fileItem.getOriginalFilename())));
      photoNameList.add(fileItem.getOriginalFilename());
    }
    classRoom.setPhotoNames(photoNameList);
    
    classRoomService.add(classRoom);
    return "redirect:list.do";
  }

  @RequestMapping("detail")
  public void detail(int no, Model model) throws Exception {
    ClassRoom classRoom = classRoomService.get(no);
    if (classRoom == null) {
      throw new Exception(no + "번 교실이 없습니다.");
    }
    model.addAttribute("classRoom", classRoom);
  } 
  
  @RequestMapping("update")
  public String update(ClassRoom classRoom, MultipartFile[] photo) throws Exception {
    ArrayList<String> photoNameList = new ArrayList<>();
    for (MultipartFile fileItem : photo) {
      if (fileItem.getSize() == 0) continue;
      fileItem.transferTo(new File(servletContext.getRealPath(
          "/classroom/photo/" + fileItem.getOriginalFilename())));
      photoNameList.add(fileItem.getOriginalFilename());
    }
    classRoom.setPhotoNames(photoNameList);
    
    classRoomService.update(classRoom);
    return "redirect:list.do";
  }
  
  @RequestMapping("delete")
  public String delete(int no) throws Exception {
    classRoomService.remove(no);
    return "redirect:list.do";
  }    
}









