package bigdata3.service;

import java.util.List;

import bigdata3.domain.Lecture;

public interface LectureService {
	List<Lecture> list(int pageNo, int pageSize) throws Exception;
	void add(Lecture lecture) throws Exception;
  Lecture get(int no) throws Exception;
  void update(Lecture lecture) throws Exception;
  void remove(int no) throws Exception;
}
