package com.reiuy.service.impl;

import com.reiuy.dao.StudentDao;
import com.reiuy.entity.Student;
import com.reiuy.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    //引用类型
    private StudentDao studentDao;

    //使用set注入来赋值
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        int nums = studentDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> queryStudents() {
        List<Student> students = studentDao.selectStudent();
        return students;
    }
}
