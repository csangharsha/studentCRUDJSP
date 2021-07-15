package np.edu.cite.controller;

import np.edu.cite.entity.Student;
import np.edu.cite.service.StudentService;
import np.edu.cite.service.impl.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "studentServlet", urlPatterns = {"/students"})
public class StudentServlet extends HttpServlet {

    private static final String VIEW_PATH = "/WEB-INF/views/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl();
        String viewPage = VIEW_PATH + "home.jsp";
        String action = req.getParameter("action");
        if("add".equals(action)) {
            viewPage = VIEW_PATH + "add_student.jsp";
        } else if("edit".equals(action)){
            viewPage = VIEW_PATH + "edit_student.jsp";
            try {
                Student student = studentService.getById(Integer.parseInt(req.getParameter("id")));
                if (student == null) {
                    resp.sendRedirect(req.getContextPath() + "/students?error");
                    return;
                }
                req.setAttribute("student", student);
            }catch (NumberFormatException e) {
                e.printStackTrace();
                resp.sendRedirect(req.getContextPath() + "/students?error");
                return;
            }
        } else if("delete".equals(action)){
            try {
                int id = Integer.parseInt(req.getParameter("id"));
                Student student = studentService.getById(Integer.parseInt(req.getParameter("id")));
                if (student == null) {
                    resp.sendRedirect(req.getContextPath() + "/students?error");
                    return;
                }
                studentService.delete(id);
                resp.sendRedirect(req.getContextPath() + "/students?success");
                return;
            }catch (NumberFormatException e) {
                e.printStackTrace();
                resp.sendRedirect(req.getContextPath() + "/students?error");
                return;
            }
        } else {
            List<Student> students = studentService.getAll();
            req.setAttribute("students", students);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl();
        Student student = new Student();
        student.setName(req.getParameter("name"));
        student.setRoll(Integer.parseInt(req.getParameter("roll")));
        student.setEnrolled(req.getParameter("enrolled") != null);
        if(req.getParameter("id") == null) {
            studentService.insert(student);
        } else {
            student.setId(Integer.parseInt(req.getParameter("id")));
            studentService.update(student);
        }

        resp.sendRedirect(req.getContextPath() + "/students?success");
    }
}


