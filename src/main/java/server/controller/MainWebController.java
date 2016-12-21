package server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainWebController {
    @RequestMapping(method = RequestMethod.GET)
    public String start(Model model){
        return "login";
    }
}