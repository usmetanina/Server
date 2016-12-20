package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import server.service.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by yanta on 18.11.2016.
 */
@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    String entityChoice;
    Entity entity = new Entity();
    List<String> listEntities = new ArrayList<String>();

    UsersController() {
        initEntityList();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(Model model) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        initModelList(model);
        usersService.Initialize();
        return "users";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String showEntityChoice(@RequestParam String entityName, Model model, HttpServletRequest request) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {

        initModelList(model);
        usersService.Initialize();
        if ( !entityName.equals("no") ) {
            entityChoice = entityName;
            usersService.tableChoice = entityChoice;
            usersService.setEntityTableChoice();

            model.addAttribute("entityChoice", entityChoice);

            HttpSession session = request.getSession(true);
            session.setAttribute("usersService", usersService);
        }

        return "users";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchRecord(Model model, HttpServletRequest request) throws IllegalAccessException {

        String phraseForSearch = request.getParameter("searchForm");
        if (phraseForSearch != null) {
            usersService.searchRecords(phraseForSearch);
            model.addAttribute("phraseForSearch", phraseForSearch);
            initModelList(model);
            return "search";
        } else {
            return "users";
        }

    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String showDetectedRecords(Model model, HttpServletRequest request) {
        initModelList(model);

        HttpSession session = request.getSession(true);
        session.setAttribute("usersService", usersService);

        return "search";
    }

    void initEntityList() {
        listEntities.add("Время проведения пары/занятия");
        listEntities.add("Группа");
        listEntities.add("День недели");
        listEntities.add("Кабинеты");
        listEntities.add("Компоненты справочника");
        listEntities.add("Корпуса");
        listEntities.add("Курс");
        listEntities.add("Неделя");
        listEntities.add("Описание кабинетов");
        listEntities.add("Пара/Занятие");
        listEntities.add("Пользователи/Администраторы");
        listEntities.add("Сотрудники");
        listEntities.add("Справочник");
        listEntities.add("Факультет");

    }

    private void initModelList(Model model) {
        model.addAttribute("entity", entity);
        model.addAttribute("listEntities", listEntities);
    }
}