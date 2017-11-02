package bigdata3.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bigdata3.dao.LectureDao;
import bigdata3.domain.Lecture;
import bigdata3.service.LectureService;

@Service
public class LectureServiceImpl implements LectureService {
	@Autowired LectureDao lectureDao;

	public List<Lecture> list(int pageNo, int pageSize) throws Exception {
	    HashMap<String,Object> valueMap = new HashMap<>();
	    valueMap.put("startIndex", (pageNo - 1) * pageSize);
	    valueMap.put("pageSize", pageSize);
	    
	    return lectureDao.selectList(valueMap);
	  }
	
  public void remove(int no) throws Exception {
    int count = lectureDao.delete(no);
    if (count < 1) {
      throw new Exception(no + "번 강의를 찾을 수 없습니다.");
    }
    try {
      count = lectureDao.delete(no);
    } catch (Exception e) {}
  }

	public void add(Lecture lecture) throws Exception {
	  lectureDao.insert(lecture);
  }

  public Lecture get(int no) throws Exception {
    return lectureDao.selectOne(no);
  }

  public void update(Lecture lecture) throws Exception {
    lectureDao.update(lecture);
  } 
} 
 