package cn.gift;


import cn.gift.domain.User;
import cn.gift.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApp.class)
public class UserServiceTest {
    @Autowired
    private IUserService userService;

    @Test
    public void testAdd() throws Exception{
        User user = new User(null,"liu");
        System.out.println(user);
        userService.insert(user);
        System.out.println(user);

    }

    @Test
    public void testDel() throws Exception{
        List<User> users = userService.selectList(null);
        users.forEach(System.out::println);
        userService.deleteById(1L);
        System.out.println("==================");
        users = userService.selectList(null);
        users.forEach(System.out::println);

    }

    @Test
    public void testUpdate() throws Exception{
        User user = userService.selectById(2L);
        System.out.println(user);
        user.setName(user.getName()+"-edit");
        userService.updateById(user);
        userService.selectById(2L);
        System.out.println(user);

    }
    @Test
    public void testGetAll() throws Exception{

        List<User> users = userService.selectList(null);
        users.forEach(System.out::println);

    }


    @Test
    public void testGetOne() throws Exception{

        System.out.println(userService.selectById(1L));

    }
}
