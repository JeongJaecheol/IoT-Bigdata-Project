package bigdata3.service;

import java.util.List;

import bigdata3.domain.Manager;

public interface ManagerService {
  List<Manager> list(int pageNo, int pageSize) throws Exception;
  Manager get(int no) throws Exception;
  Manager getByEmailPassword(String email, String password) throws Exception;
  void add(Manager manager) throws Exception;
  void update(Manager manager) throws Exception;
  void remove(int no) throws Exception;
  

}
