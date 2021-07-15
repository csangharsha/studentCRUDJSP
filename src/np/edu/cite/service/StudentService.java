package np.edu.cite.service;

import np.edu.cite.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();

    void insert(Student student);

    Student getById(int id);

    void update(Student student);

    void delete(int id);
}
