package com.reiuy.ba03;

public class Student {
    private String name;
    private int age;

    //声明一个引用类型
    private School school;


    /**
     * 创建一个有参的构造方法
     */
    public Student(String myname,int myage,School myschool){
        System.out.println("调用了Student的有参数构造方法");
        this.name = myname;
        this.age = myage;
        this.school = myschool;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(School school) {
        this.school = school;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
