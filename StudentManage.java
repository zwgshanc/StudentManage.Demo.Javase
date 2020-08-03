package com.xs;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManage {
    public static void main(String[] args) {
        //用输入语句完成主界面的编写
        ArrayList<Student> array = new ArrayList<Student>();
        while (true) {
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择：");
            //键盘录入
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            switch (line) {
                case "1":
                    addStudent(array);
                    break;
                case "2":
                    deleteStudent(array);
                    break;
                case "3":
                    setStudent(array);
                    break;
                case "4":
                    findStudent(array);
                    break;
                case "5":
                    System.out.println("退出系统");
                    System.exit(0);

            }
        }
    }

    //添加学生
    public static void addStudent(ArrayList<Student> array) {
        //键盘录入学生个人信息
        String sid;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入学生学号");
            sid = sc.nextLine();
            boolean flag = isUsed(array, sid);
            if (flag) {
                System.out.println("你输入的学号已经使用，请重新输入");
            }else {
                break;
            }
        }
        System.out.println("请输入学生姓名");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄");
        String age = sc.nextLine();
        System.out.println("请输入学生居住地");
        String address = sc.nextLine();
        //创建学生对象，把键盘录入的值赋值给学生对像
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        //将学生对象添加到集合
        array.add(s);
        System.out.println("添加学生成功");
    }

    //查找学生
    public static void findStudent(ArrayList<Student> array) {
        if (array.size() == 0) {
            System.out.println("无信息，请先添加信息再查询");
            //为了程序不向下运行
            return;
        }
        System.out.println("学号\t姓名\t年龄\t居住地");
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getSid() + "\t\t" + s.getName() + "\t" + s.getAge() + "岁" + "\t" + s.getAddress());
        }
    }

    //删除学生
    public static void deleteStudent(ArrayList<Student> array){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生学号");
        String sid = sc.nextLine();
        int index = -1;
        for (int i = 0; i <array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)){
                index = i;
                break;
            }
            if(index==-1){
                System.out.println("信息不存在");
            }else {
                array.remove(i);
                System.out.println("删除学生成功");
            }
        }

    }

    //修改学生
    public static void setStudent(ArrayList<Student> array){
        Scanner sc= new Scanner(System.in);
        System.out.println("请输入要修改的学生学号：");
        String sid = sc.nextLine();
        System.out.println("请输入学生新姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生新年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生新居住地：");
        String address = sc.nextLine();
        //创建学生对象
        Student s= new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        for (int i = 0; i <array.size() ; i++) {
            Student student = array.get(i);
            if(student.getSid().equals(sid)){
                array.set(i,s);
                break;
            }

        }
        System.out.println("修改学生成功");
    }

    public static boolean isUsed(ArrayList<Student> array, String sid){
        boolean flag = false;
        for (int i = 0; i <array.size() ; i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)){
                flag = true;
                break;
            }

        }
        return flag;

    }
}
