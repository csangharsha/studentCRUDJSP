package np.edu.cite.service.impl;

import np.edu.cite.dao.StudentDao;
import np.edu.cite.dao.impl.StudentDaoImpl;
import np.edu.cite.entity.Student;
import np.edu.cite.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public StudentServiceImpl() {
        studentDao = new StudentDaoImpl();
    }

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public void insert(Student student) {
        studentDao.insert(student);
    }

    @Override
    public Student getById(int id) {
        return studentDao.getById(id);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public void delete(int id) {
        studentDao.delete(id);
    }
}
