package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import server.service.EditingService;
import server.service.EditingService.*;
import server.service.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanta on 25.11.2016.
 */
@Controller
public class EditController {

    @Autowired
    UsersService usersService;
    @Autowired
    EditingService editingService;

    EditToolsClass editToolsClass = new EditToolsClass();

    @RequestMapping(value = "/edit*", method = RequestMethod.GET)
    public String getRecordForEdition(Model model, HttpServletRequest request) throws IllegalAccessException {

        String Id = request.getParameter("RecordId");
        usersService.pickedRecord = Integer.parseInt(Id);

        HttpSession session = request.getSession(true);
        session.setAttribute("usersService", usersService);

        return "edit";
    }

    @RequestMapping(value = "/delete*", method = RequestMethod.GET)
    public String getRecordForDeleting(Model model, HttpServletRequest request) throws IllegalAccessException {

        String Id = request.getParameter("RecordId");
        usersService.pickedRecord = Integer.parseInt(Id);

        HttpSession session = request.getSession(true);
        session.setAttribute("usersService", usersService);

        editingService.deleteRecordById(usersService.pickedRecord, usersService.pickedRecord, usersService.tableChoice);

        usersService.setInitializationState(false);

        usersService.getTableData(usersService.tableChoice);

        return "redirect:/users";
    }

    @RequestMapping(value = "/clearRecord", method = RequestMethod.GET)
    public String getRecordForDeletingByName(Model model, HttpServletRequest request) throws IllegalAccessException {

        HttpSession session = request.getSession(true);
        session.setAttribute("usersService", usersService);

        editingService.deleteRecordById(usersService.pickedRecord, usersService.pickedRecord, usersService.tableChoice);

        usersService.setInitializationState(false);

        usersService.getTableData(usersService.tableChoice);

        return "redirect:/users";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveChanges(Model model, HttpServletRequest request) throws IllegalAccessException {

        List<String> listColumns = usersService.ListOfColumnNamesForTable;
        List<String> updatedFieldsList = new ArrayList<String>();
        String updatedField;

        for (int i = 0; i < listColumns.size(); i++) {
            updatedField = request.getParameter(listColumns.get(i));
            if (updatedField != null) {
                updatedFieldsList.add(updatedField);
            } else {
                updatedFieldsList.add("/* не заполнено */");
            }
        }

        Object objectForUpdate = usersService.dataBaseMap.get(usersService.tableChoice).get(usersService.pickedRecord - 1);
        Object updatedObject = editToolsClass.editPickedRecord(objectForUpdate, updatedFieldsList);
        editingService.saveChangesForRecord(updatedObject, usersService.tableChoice);

        usersService.getTableData(usersService.tableChoice);

        return "redirect:/users";
    }

}
