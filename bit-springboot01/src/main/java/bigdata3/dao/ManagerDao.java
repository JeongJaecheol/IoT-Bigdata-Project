package bigdata3.dao;

import java.util.List;
import java.util.Map;

import bigdata3.domain.Manager;
 
public interface ManagerDao {

  List<String> selectPhotoName(int managerNo);

  List<Manager> selectList(Map<String, Object> valueMap);

  Manager selectOne(int no);

  Manager selectOneByEmailPassword(Map<String, Object> valueMap);

  int insert(Manager manager);

  int update(Manager manager);
  
  int delete(int no);

}
