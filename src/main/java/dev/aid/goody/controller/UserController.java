package dev.aid.goody.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * todo
 *
 * @author: 04637@163.com
 * @date: 2020/5/1
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @RequestMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("hello this is test");
    }
}
