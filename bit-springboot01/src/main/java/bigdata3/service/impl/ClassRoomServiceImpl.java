package bigdata3.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bigdata3.dao.ClassRoomDao;
import bigdata3.domain.ClassRoom;
import bigdata3.service.ClassRoomService;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {
  @Autowired ClassRoomDao classRoomDao;
  
  public List<ClassRoom> list(int pageNo, int pageSize) throws Exception {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("startIndex", (pageNo - 1) * pageSize);
    valueMap.put("pageSize", pageSize);
    
    return classRoomDao.selectList(valueMap);
  }
  
  public void add(ClassRoom classRoom) throws Exception {
    classRoomDao.insert(classRoom);
    this.insertPhoto(classRoom); // 교실 사진 추가
  }
  
  public ClassRoom get(int no) throws Exception {
    return classRoomDao.selectOne(no);
  }
  
  public void update(ClassRoom classRoom) throws Exception {
    classRoomDao.update(classRoom);
    classRoomDao.deletePhoto(classRoom.getNo());
    this.insertPhoto(classRoom);
  }  
  
  public void remove(int no) throws Exception {
    classRoomDao.deletePhoto(no);
    int count = classRoomDao.delete(no);
    if (count < 1) {
      throw new Exception(no + "번 교실을 찾을 수 없습니다.");
    }
  }
  
  private void insertPhoto(ClassRoom classRoom) {
    HashMap<String,Object> valueMap = new HashMap<>();
    valueMap.put("classroomNo", classRoom.getNo());
    
    for (String photoName : classRoom.getPhotoNames()) {
      valueMap.put("photoName", photoName);
      classRoomDao.insertPhoto(valueMap);
    }
  }
}







