package service;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import repo.UserRepo;

@Service
public class LoginService {

    @Autowired
    UserRepo userRepo;

    public boolean login(String id, String pwd){
        boolean result = checkPassword(id, pwd);
        
        
        // 기능 추가 필

        return result;
    }

    public boolean checkPassword(String id, String pwd){

        User user = userRepo.findById(id);

        if(ObjectUtils.isEmpty(user) || StringUtils.hasText(user.getUserPassword()) == false)
            return false;
        return user.getUserPassword().equals(pwd);
    }

}
