package bigdata3.dao;

import java.util.List;
import java.util.Map;

import bigdata3.domain.ClassRoom;
 
public interface ClassRoomDao {
  List<ClassRoom> selectList(Map<String,Object> valueMap);
  int insert(ClassRoom classRoom);
  ClassRoom selectOne(int no);
  int update(ClassRoom classRoom);
  int delete(int no);
  void insertPhoto(Map<String,Object> valueMap);
  void deletePhoto(int no);
}
