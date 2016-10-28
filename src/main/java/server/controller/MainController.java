package server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(value = "/teacher" , method = RequestMethod.GET)
    @ResponseBody
    public  String getTeacher(ModelMap model) {
        return "Hi";
    }
}
