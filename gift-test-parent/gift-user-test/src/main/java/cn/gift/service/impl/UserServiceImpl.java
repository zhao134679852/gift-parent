package cn.gift.service.impl;

import cn.gift.domain.User;
import cn.gift.mapper.UserMapper;
import cn.gift.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yaosang
 * @since 2023-04-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
