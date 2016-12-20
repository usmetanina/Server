package server.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import server.entity.User;
import server.service.UserService;
import server.service.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
//@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private UsersService usersService;

    public String warning = "Invalid login or password. Please, try again...";

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String loginForm(Model model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkLogin(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        model.addAttribute("warning", warning);
        //model.addAttribute("listEntities", usersService.getlistEntities());
        HttpSession session = request.getSession(true);
        session.setAttribute("usersService", usersService);

        request.setCharacterEncoding("utf-8");
        User user = userService.getUser(request.getParameter("login"));
        if (user != null) {
            if (user.getPassword().equals(request.getParameter("password"))) {
                model.addAttribute("user", user);
                usersService.currentUser = user.getLogin();
                usersService.unsuccessfulAuthorisation = false;
                return "redirect:/users";
            } else {
                usersService.unsuccessfulAuthorisation = true;
                return "login";
            }
        } else {
            usersService.unsuccessfulAuthorisation = true;
            return "login";
        }

    }

}