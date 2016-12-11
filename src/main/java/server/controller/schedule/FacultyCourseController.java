package server.controller.schedule;

import org.springframework.web.bind.annotation.*;
import server.dto.schedule.FacultyCourseDto;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/")
public class FacultyCourseController {

    @RequestMapping(value = "/facultyCourseEntity" , method = RequestMethod.GET)
    @ResponseBody
    public List<FacultyCourseDto> getAllFacultiesWithoutCourses() {
        List <FacultyCourseDto> result = new LinkedList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/csu", "root", "root");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM faculty_course");
            while (rs.next())
            {
                FacultyCourseDto newRow = new FacultyCourseDto();
                newRow.setCourseId(rs.getInt("course_id"));
                newRow.setFacultyId(rs.getInt("faculty_id"));

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
