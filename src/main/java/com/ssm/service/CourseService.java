package com.ssm.service;

import com.ssm.domain.Course;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CourseService {

    /**
     * 保存
     * @param course
     * @return
     */
    public boolean save(Course course);

    /**
     * 修改
     * @param course
     * @return
     */
    public boolean update(Course course);

    /**
     * 按id删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 按id查找
     * @param id
     * @return
     */
    public Course getById(Integer id);

    /**
     * 查找全部
     * @return
     */
    public List<Course> getAll();

    /**
     * 查找除了某id以外的全部
     * @param id
     * @return
     */
    public List<Course> getAllExcepte(Integer id);

    public List<Course> getBySid(Integer sid);

    public boolean updatexo(Course course);
}
