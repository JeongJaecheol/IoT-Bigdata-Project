package bigdata3.service;

import java.util.List;

import bigdata3.domain.Student;

public interface StudentService {
  List<Student> list(int pageNo, int pageSize) throws Exception;
  void add(Student student) throws Exception;
  Student get(int no) throws Exception;
  void update(Student student) throws Exception;
  void remove(int no) throws Exception;
}
