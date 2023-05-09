package com.ssm.service.impl;

import com.ssm.controller.Code;
import com.ssm.dao.CourseDao;
import com.ssm.domain.Course;
import com.ssm.exception.BusinessException;
import com.ssm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public boolean save(Course course) {
        courseDao.save(course);
        return true;
    }

    @Override
    public boolean update(Course course) {
        courseDao.update(course);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        courseDao.delete(id);
        return true;
    }

    @Override
    public Course getById(Integer id) {

        if(id <01){
            throw new BusinessException(Code.BUSINESS_ERR,"请勿进行非法操作!");
        }
        return courseDao.getById(id);
    }



    @Override
    public List<Course> getAll() {
        return courseDao.getAll();
    }

    @Override
    public List<Course> getAllExcepte(Integer id) {
        return courseDao.getAllExcepte(id);
    }

    @Override
    public List<Course> getBySid(Integer sid) {
        return courseDao.getBySid(sid);
    }

    @Override
    public boolean updatexo(Course course){
        courseDao.updatexo(course);
        return true;
    }
}
