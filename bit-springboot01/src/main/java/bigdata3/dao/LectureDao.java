package bigdata3.dao;

import java.util.List;
import java.util.Map;

import bigdata3.domain.Lecture;
 
public interface LectureDao {
	List<Lecture> selectList(Map<String,Object> valueMap);
  Lecture selectOne(int no);
	int delete(int no);
  int insert(Lecture lecture);
  int update(Lecture lecture);
  
}
  
