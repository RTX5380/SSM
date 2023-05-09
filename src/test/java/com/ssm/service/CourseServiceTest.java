package com.ssm.service;

import com.ssm.config.SpringConfig;
import com.ssm.controller.Code;
import com.ssm.controller.Result;
import com.ssm.domain.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @Test
    public void testSelectById(){
        Course course = courseService.getById(2);
        System.out.println(course);
    }

    @Test
    public void testGetAll(){
        List<Course> all = courseService.getAll();
        System.out.println(all);
    }

    @Test
    public void testGetBySid(){
        List<Course> computer = courseService.getBySid(1);
        System.out.println(computer);
    }

    @Test
    public void testUpdatexo(){
        Course course = new Course();
        course.setHours(40);
        course.setId(4);
        courseService.updatexo(course);
    }

    @Test
    public void testSave(){
        Course course = new Course();
        course.setHours(32);
        course.setSid(1);
        course.setName("C语⾔程序设");
        int x = 0;
        boolean flag = false;
        List<Course> all = courseService.getAll();
        for (int i = 0;i < all.size();i++){
            Course course1 = all.get(i);
            if (course1.getName().equals(course.getName())){
                x = 1;
                break;
            }
        }
        if(x == 0){
            courseService.save(course);
        } else {
            System.out.println("失败!!!");
        }
    }
}
