package server.controller.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.schedule.FacultyCourseDto;
import server.dto.schedule.LessonWithAllIdDto;
import server.entity.schedule.Lesson;
import server.service.schedule.LessonService;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/")
public class LessonController {

    @Autowired
    LessonService lessonService;

    @RequestMapping(value = "/lessonEntity" , method = RequestMethod.GET)
    @ResponseBody
    public List<LessonWithAllIdDto> getAllFacultiesWithoutCourses() {
        List<Lesson> list = lessonService.getAll();
        List<LessonWithAllIdDto> result = new ArrayList<>(list.size());
        list.forEach(lesson -> result.add(LessonWithAllIdDto.fromModel(lesson)));
        return result;
    }

    @RequestMapping(value = "/lessonsByGroup/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public List<LessonWithAllIdDto> getLessonByGroup(@PathVariable int id) {
        List <LessonWithAllIdDto> result = new LinkedList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/csu", "root", "root");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM lesson WHERE studentGroup="+id);
            while (rs.next())
            {
                LessonWithAllIdDto newRow = new LessonWithAllIdDto();
                newRow.setStudentGroup(rs.getInt("studentGroup"));
                newRow.setWeek(rs.getInt("week"));
                newRow.setDayOfWeek(rs.getInt("dayOfWeek"));
                newRow.setCabinet(rs.getInt("cabinet"));
                newRow.setEmployee(rs.getInt("employee"));
                newRow.setId(rs.getInt("id"));
                newRow.setNameOfSubject(rs.getString("name_subject"));
                newRow.setSubgroup(rs.getInt("subgroup"));
                newRow.setTime(rs.getInt("time"));
                newRow.setTypeOfLesson(rs.getString("type_lesson"));
                result.add(newRow);
            }
        }
        catch (SQLException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

}
