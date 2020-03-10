package l8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class StudentsRestController {
    private StudentsService studentsService;

    @Autowired
    public void setStudentsService(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @CrossOrigin
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentsService.getStudentById(studentId);
    }

    @GetMapping("/students")
    public List<Student> getStudentById() {
        return studentsService.getAllStudentsList();
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        student.setId(0L);
        student = studentsService.saveOrUpdate(student);
        return student;
    }

    @PutMapping(path = "/students", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Student updateStudent(@RequestBody Student student) {
        student = studentsService.saveOrUpdate(student);
        return student;
    }

    @DeleteMapping("/students/{studentId}")
    public int deleteStudent(@PathVariable Long studentId) {
        studentsService.delete(studentId);
        return HttpStatus.OK.value();
    }
}
