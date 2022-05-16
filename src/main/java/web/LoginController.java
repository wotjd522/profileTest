package web;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repo.UserRepo;
import service.LoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    LoginService ls;

    @RequestMapping("/")
    public String index(ModelMap mm){
        mm.put("users", userRepo.findAll());
        return "index";
    }

    @RequestMapping("/login")
    public String login(ModelMap mm){
        mm.put("users", userRepo.findAll());
        return "login";
    }

    @RequestMapping ("/loginAction")
    public String loginAction (User u, HttpServletResponse response){
        if(ls.checkPassword(u.getUserId(), u.getUserPassword())){

            Cookie loginCookie = new Cookie("logininfo", u.getUserId());
            // 원래는 id와 pw를 같이 집어넣은 쿠키를 만들어야 합니다.
            // 편한 테스트를 위해서 분리가 필요없게 id만 넣었습니다.
            loginCookie.setMaxAge(60*60*30);  // 유효기간 30분

            response.addCookie(loginCookie);

            return "myprofile";

        } else {
            return "redirect:/login";
        }
    }
}
