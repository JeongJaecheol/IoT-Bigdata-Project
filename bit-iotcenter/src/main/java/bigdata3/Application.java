/* 아두이노 장비 제어를 위한 페이지 컨트롤러 추가
 * => ArduinoControl 작성
 * 
 */

package bigdata3;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement // 트랜잭션 관리 객체 생성 
@MapperScan("bigdata3.dao") // DAO 인터페이스로부터 클래스 자동 생성
public class Application {

  @Bean 
  @ConfigurationProperties("app.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }
  
  public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
  }

}