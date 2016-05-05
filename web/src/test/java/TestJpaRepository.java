import com.spring.domain.UserEntity;
import com.spring.repository.UserRepository;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vietquocpham
 * Date: 4/26/16
 * Time: 11:32
 * To change this template use File | Settings | File Templates.
 */
public class TestJpaRepository {

    private static UserRepository userRepository;

    public static void main(String[] args){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        userRepository = context.getBean(UserRepository.class);
        UserEntity userEntity = userRepository.fetchBySearchTerm("admin").get(0);

        context.close();
    }
}
