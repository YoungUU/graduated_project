package com.cqupt.ysc.graduation.project.web.admin.dao;

import com.cqupt.ysc.graduation.project.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    List<Student> getStudents(String email);
    Student getStudentById(long id);
    void deleteStudentById(long id);
    void saveStudent(Student student);
    void updateStudentById(Student student);
    List<Student> searchStudent(Student student);
}
