package bigdata3.web;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import bigdata3.domain.Student;
import bigdata3.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentControl {
  @Autowired StudentService studentService;
  @Autowired ServletContext servletContext;
  
  
  @RequestMapping("list")
  public String list( 
      
  @RequestParam(defaultValue="1") int pageNo,
  @RequestParam(defaultValue="5") int pageSize,
    Model model) throws Exception {
    List<Student> list = studentService.list(pageNo, pageSize);
      model.addAttribute("list", list);
        return "student/list";
  }
  
  @RequestMapping("form")
  public void form() {
  }
  
  @RequestMapping("add")
  public String add(Student student, MultipartFile photo) throws Exception {
    if (photo.getSize() != 0) {
      photo.transferTo(new File(servletContext.getRealPath(
        "/student/photo/" + photo.getOriginalFilename())));
    
      student.setPhotoName(photo.getOriginalFilename());
    }
    studentService.add(student);
    return "redirect:list.do"; 
  }
  
  @RequestMapping("detail")
  public String detail(int no, Model model) throws Exception {
    Student student = studentService.get(no);
    if (student == null) {
      throw new Exception(no + "번 학생 없습니다.");
    }
    model.addAttribute("student", student);
    return "student/detail";
  }
  
  @RequestMapping("update")
  public String update(Student student, MultipartFile photo) throws Exception {
    if (photo.getSize() != 0) {
      photo.transferTo(new File(servletContext.getRealPath(
        "/student/photo/" + photo.getOriginalFilename())));
    
      student.setPhotoName(photo.getOriginalFilename());
     }
    studentService.update(student);
    return "redirect:list.do";
  }
  @RequestMapping("delete")
  public String delete(int no) throws Exception {
    studentService.remove(no);
    return "redirect:list.do";
  }
}









