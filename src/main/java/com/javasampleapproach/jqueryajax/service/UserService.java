
package com.javasampleapproach.jqueryajax.service;

import com.javasampleapproach.jqueryajax.model.User;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class UserService {

    private List<User> users;

    //fungsi mencari username
    public List<User> findByAll(String username) {

        List<User> result = users.stream().filter(x -> x.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList());

        return result;

    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginForm") User loginForm, Model model, String username, String password) {
        if (loginForm.getUsername().equals("regitarachma") && loginForm.getPassword().equals("123456")) {
            return "login";
        }
        model.addAttribute("invalidCredentials", true);

        return "login";
    }

    // coba data manual testing
//    @PostConstruct
//    private void Testing() {
//
//        users = new ArrayList<User>();
//
//        User user1 = new User("regitarachma", "123456", "regitarachma@gmail.com");
//
//        users.add(user1);
//
//    }

}
