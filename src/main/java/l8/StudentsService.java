package l8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {
    private StudentsRepository studentsRepository;

    @Autowired
    public void setStudentsRepository(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public Student getStudentById(Long id) {
        Optional<Student> student = studentsRepository.findById(id);
        return student.get();
    }

    public Student saveOrUpdate(Student student) {
        return studentsRepository.save(student);
    }

    public void delete(Long id) {
        Optional<Student> student = studentsRepository.findById(id);
        studentsRepository.delete(student.get());
    }

    public List<Student> getAllStudentsList() {
        return (List<Student>) studentsRepository.findAll();
    }
}
