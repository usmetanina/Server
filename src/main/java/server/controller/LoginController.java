package server.controller;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import server.entity.User;
import server.repository.UserRepository;
import server.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;
    public String warning = "Invalid login or password. Please, try again...";

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String loginForm(Model model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkLogin(HttpServletRequest request, Model model) {
        model.addAttribute("warning", warning);
        User user = userService.getUser(request.getParameter("login"));
        if (user != null) {
            if (user.getPassword().equals(request.getParameter("password"))) {
                model.addAttribute("user", user);
                return "users";
            } else {
                return "login";
            }
        } else {
            return "login";
        }

    }

}