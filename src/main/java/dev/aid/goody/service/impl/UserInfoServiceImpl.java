package dev.aid.goody.service.impl;

import dev.aid.goody.entity.UserInfo;
import dev.aid.goody.dao.UserInfoMapper;
import dev.aid.goody.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 04637@163.com
 * @since 2020-05-01
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
