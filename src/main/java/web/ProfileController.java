package web;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import repo.UserRepo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    UserRepo userRepo;

    @RequestMapping("/myprofile")
    public String myprofile(User u,
        @CookieValue(value = "logininfo", required = false)Cookie loginCookie,
        HttpServletRequest request,
        ModelMap mm){

        if(loginCookie == null){
            return "login";
        } else {
            mm.put("user", userRepo.findById(loginCookie.getValue()));
        }
        return "myprofile";
    }
    @RequestMapping("/editprofile")
    public String editprofile(User u,
          @CookieValue(value = "logininfo", required = false)Cookie loginCookie,
          HttpServletRequest request,
          ModelMap mm){
        if (loginCookie == null){
            return "login";
        } else {
            mm.put("user", userRepo.findById(loginCookie.getValue()));
        }
        return "editprofile";
    }
    @RequestMapping("/editprofileAction")
    public String editprofile(User u){
        userRepo.update(u);
        return "myprofile";
    }
}
