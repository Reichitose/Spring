package com.reiuy.dao;

import com.reiuy.entity.Student;

import java.util.List;

public interface StudentDao {

    int insertStudent(Student student);

    List<Student> selectStudent();
}
