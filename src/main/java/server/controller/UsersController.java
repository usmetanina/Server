package server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yanta on 08.12.2016.
 */
@Controller
@RequestMapping("/users")
public class UsersController {
    @RequestMapping(method = RequestMethod.GET)
    public String start(Model model){
        return "users";
    }
}
