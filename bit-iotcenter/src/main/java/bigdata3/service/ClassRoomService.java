package bigdata3.service;

import java.util.List;

import bigdata3.domain.ClassRoom;

public interface ClassRoomService {
  List<ClassRoom> list(int pageNo, int pageSize) throws Exception;
  void add(ClassRoom classRoom) throws Exception;
  ClassRoom get(int no) throws Exception;
  void update(ClassRoom classRoom) throws Exception;
  void remove(int no) throws Exception;
}







