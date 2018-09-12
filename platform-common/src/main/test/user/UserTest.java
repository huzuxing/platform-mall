package user;

import com.cyc.platform.common.Application;
import com.cyc.platform.common.dao.UserMapper;
import com.cyc.platform.common.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by huzuxing on 2018/9/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void add() {
        User user = new User();
        user.setId(1);
        user.setAge(23);
        user.setUserName("huzuxing");
        userMapper.save(user);
        System.out.println("新增数据: " + user.toString());
    }
}

