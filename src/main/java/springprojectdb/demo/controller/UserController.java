package springprojectdb.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springprojectdb.demo.models.User;
import springprojectdb.demo.models.UserLoginPost;

import springprojectdb.demo.models.UserRegisterPost;
import springprojectdb.demo.service.UserServise;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {


    @RestController
    public class UsersController {

        @Autowired
        UserServise userServise;

        @GetMapping(value = "/a")
        public String showA() {
            return "12345";
        }





                @PostMapping(value = "/register")
        public Map<String, Object> registerUser(@RequestBody UserRegisterPost userRegisterPost) {
            Map<String, Object> map = new HashMap<>();
            if (userServise.findByLogin(userRegisterPost.getLogin()).isPresent()) {
                map.put("success", "false");
                map.put("message", "Incorrect email or password. Please try again");
                map.put("data", null);
            } else {
                User user = new User();
                user.setFirstName(userRegisterPost.getFirstName());
                user.setLastName(userRegisterPost.getLastName());
                user.setLogin(userRegisterPost.getLogin());
                user.setPassword(userRegisterPost.getPassword());
                userServise.saveAndFlush(user);
                map.put("success", "true");
                map.put("message", "Registration Successfully");
                map.put("data", user);

            }
            return map;
        }


//        @PostMapping(value = "/login")
//        public Map<String, Object> registerUser(@RequestBody UserLoginPost userLoginPost) {
//            Map<String, Object> map = new HashMap<>();
//            if (userServise.findByLoginAndPassword(userLoginPost.getLogin(), userLoginPost.getPassword()).isPresent()) {
//                map.put("success", String.valueOf(true));
//                map.put("message", "Login Successfully");
//                map.put("data", userServise.findByLoginAndPassword(userLoginPost.getLogin(), userLoginPost.getPassword()));
//            } else {
//                map.put("success", String.valueOf(false));
//                map.put("message", "Login Failed");
//                map.put("data", null);
//            }
//            return map;
//        }

        @GetMapping(value = "getAllUsers")
        public List<User> getALLUsers() {
            return userServise.findAll();
        }


    }
}



