package bigdata3.service.impl;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bigdata3.dao.ManagerDao;
import bigdata3.dao.MemberDao;
import bigdata3.domain.Manager;
import bigdata3.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

  @Autowired
  ManagerDao managerDao;
  @Autowired
  MemberDao memberDao;
  
  public List<Manager> list(int pageNo, int pageSize) throws Exception {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("startIndex", (pageNo - 1) * pageSize);
    valueMap.put("pageSize", pageSize);
    
    return managerDao.selectList(valueMap);
  }
  
  public Manager get(int no) throws Exception {
    return managerDao.selectOne(no);
  }
  public void add(Manager manager) throws Exception {
    memberDao.insert(manager);
    managerDao.insert(manager);
   

  }
  
  public void update(Manager manager) throws Exception {
    int count = memberDao.update(manager);
    if (count < 1) {
      throw new Exception(manager.getNo() + "번 매니저를 찾을 수 없습니다.");
    }
    count = managerDao.update(manager);
    if (count < 1) {
      throw new Exception(manager.getNo() + "번 매니저를 찾을 수 없습니다.");
    }
 }

  
  public Manager getByEmailPassword(String email, String password) throws Exception {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("email", email);
    valueMap.put("password", password);
    

    return managerDao.selectOneByEmailPassword(valueMap);
  }
  
  public void remove(int no) throws Exception {
    int count = managerDao.delete(no);
    if (count < 1) {
      throw new Exception(no + "번 학생을 찾을 수 없습니다.");
    }
    
    try {
      count = memberDao.delete(no);
    } catch (Exception e) {}
  }
}
