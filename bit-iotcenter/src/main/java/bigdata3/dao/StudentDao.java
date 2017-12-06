package bigdata3.dao;

import java.util.List;
import java.util.Map;

import bigdata3.domain.Student;
 
public interface StudentDao { 
  List<Student> selectList(Map<String,Object> valueMap); 
  int insert(Student student);
  Student selectOne(int no);
  int update(Student student); 
  int delete(int no);
} 
