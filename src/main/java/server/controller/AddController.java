package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import server.service.EditingService;
import server.service.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanta on 26.11.2016.
 */

@Controller
public class AddController {

    @Autowired
    UsersService usersService;
    @Autowired
    EditingService editingService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getRecordForEdition(Model model, HttpServletRequest request) throws IllegalAccessException {

        HttpSession session = request.getSession(true);
        session.setAttribute("usersService", usersService);

        return "add";
    }

    @RequestMapping(value = "/add/save", method = RequestMethod.POST)
    public String saveChanges(Model model, HttpServletRequest request) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {

        List<String> listColumns = usersService.currentEntityTable.columnNames;
        List<String> newFieldsList = new ArrayList<String>();
        String newField;

        for (int i = 0; i < listColumns.size(); i++) {
            newField = request.getParameter(listColumns.get(i));
            if (newField != null && !newField.equals("")) {
                newFieldsList.add(newField);
            } else {
                newFieldsList.add("/* не заполнено */");
            }
        }

        editingService.addNewRecord(newFieldsList);

        return "redirect:/users";
    }

}
