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

import bigdata3.domain.Manager;
import bigdata3.service.ManagerService;


@Controller
@RequestMapping("/manager")
public class ManagerControl {

  @Autowired ManagerService managerService;
  @Autowired ServletContext servletContext;
  
  @RequestMapping("list")
  public String list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="5") int pageSize,
      Model model) throws Exception { 
    
    List<Manager> list = managerService.list(pageNo, pageSize);
    model.addAttribute("list", list);
    
    return "manager/list";
  }
  
  @RequestMapping("add")
  public String add(Manager manager, MultipartFile photo) throws Exception {

    MultipartFile fileItem = photo;

    if (fileItem.getSize() != 0) {
      fileItem.transferTo(new File(servletContext.getRealPath(
        "/manager/photo/" + fileItem.getOriginalFilename())));
    
      manager.setPhotoName(fileItem.getOriginalFilename());
    }
    managerService.add(manager);
    return "redirect:list.do"; 
  }

  @RequestMapping("update")
  public String update(Manager manager, MultipartFile photo) throws Exception {
    MultipartFile fileItem = photo;

    if (fileItem.getSize() != 0) {
      fileItem.transferTo(new File(servletContext.getRealPath(
        "/manager/photo/" + fileItem.getOriginalFilename())));
    
      manager.setPhotoName(fileItem.getOriginalFilename());
    }
    managerService.update(manager);
    return "redirect:list.do"; 
  }

  
  @RequestMapping("form")
  public void form() {
    
    }
  
  @RequestMapping("detail")
  public void detail(int no, Model model) throws Exception {
    Manager manager = managerService.get(no);
    if (manager == null) {
      throw new Exception(no + "번 매니저가 없습니다.");
    }
    model.addAttribute("manager", manager);
  
  }

  @RequestMapping("delete")
  public String delete(int no) throws Exception {
    managerService.remove(no);
    return "redirect:list.do";
  }
}
  

