package com.ssm.dao;

import com.ssm.domain.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CourseDao {

    //@Insert("insert into tbl_book values(null,#{type},#{name},#{description})")
    @Insert("insert into c_course (name,hours,sid,coursePic) values(#{name},#{hours},#{sid},#{coursePic})")
    public void save(Course course);

    @Update("update c_course set hours = #{hours}, name = #{name}, sid = #{sid}, coursePic = #{coursePic} where id = #{id}")
    public void update(Course course);

    @Update("update c_course set hours = #{hours} where id = #{id}")
    public void updatexo(Course course);

    @Delete("delete from c_course where id = #{id}")
    public void delete(Integer id);

    @Select("select * from c_course where id = #{id}")
    public Course getById(Integer id);

    @Select("select * from c_course order by sid")
    public List<Course> getAll();

    @Select("select * from c_course where id != #{id}")
    public List<Course> getAllExcepte(Integer id);

    @Select("select * from c_course where sid = #{sid}")
    public List<Course> getBySid(Integer sid);
}

