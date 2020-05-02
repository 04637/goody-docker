package dev.aid.goody.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import dev.aid.goody.entity.UserInfo;
import dev.aid.goody.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 04637@163.com
 * @since 2020-05-01
 */
@RestController
@RequestMapping("/userInfo")
@Slf4j
public class UserInfoController {

    private UserInfoService userInfoService;

    @RequestMapping("/select")
    public ResponseEntity<String> select() {
        String name = "hello1";
        log.info("select name: {}", name);
        QueryWrapper<UserInfo> qw = new QueryWrapper<>();
        qw.lambda().eq(UserInfo::getName, name);
        List<UserInfo> result = userInfoService.list(qw);
        return ResponseEntity.ok("select done");
    }

    @RequestMapping("/insert")
    public ResponseEntity<String> insert() {
        log.info("insert");
        userInfoService.save(new UserInfo().setAge("13").setName("hello").setBio(
                    "im da ming"));
        return ResponseEntity.ok("insert done");
    }

    @Autowired
    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }
}

