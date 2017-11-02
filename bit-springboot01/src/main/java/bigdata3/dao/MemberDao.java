package bigdata3.dao;

import java.util.List;
import java.util.Map;

import bigdata3.domain.Member;
 
public interface MemberDao {
  List<Member> selectList(Map<String,Object> valueMap);
  List<Member> selectListByNames(Map<String,Object> valueMap);
  Member selectOne(int no);
  Member selectOneByEmailPassword(Map<String,Object> valueMap);
  int insert(Member member);
  int update(Member member);
  int delete(int no) throws Exception;
}
