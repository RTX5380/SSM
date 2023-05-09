package com.ssm.controller;

import com.ssm.domain.Course;
import com.ssm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.UUID;

class temp{
    static String imageUrl = null;
}

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/upload")
    public Result upload(@RequestParam(value = "file") MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //使用UUID重新生成文件名，防止文件名称重复造成文件覆盖
        String fileName = UUID.randomUUID().toString() + suffix;
        File dir = new File("C:\\Users\\25683\\IdeaProjects\\SY2\\src\\main\\webapp\\pages\\image");
        if(!dir.exists()){
            //目录不存在，需要创建
            dir.mkdirs();
        }

        try {
            file.transferTo(new File("C:\\Users\\25683\\IdeaProjects\\SY2\\src\\main\\webapp\\pages\\image\\"+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        temp.imageUrl = "image/"+fileName;
        return null;
    }

    @PostMapping
    public Result save(@RequestBody Course course) throws IOException {
        boolean x = false;
        boolean flag = false;
        String str1 = course.getName();
        String str2;
        List<Course> all = courseService.getAll();
        for (int i = 0;i < all.size();i++){
            Course course1 = all.get(i);
            str2 = course1.getName();
            str1 = new String(str1.getBytes("ISO-8859-1"),"UTF-8");
            str2 = new String(str2.getBytes("ISO-8859-1"),"UTF-8");
            if (str1.equals(str2)){
                x = true;
                break;
            }
        }
        course.setCoursePic(temp.imageUrl);
        if(course.getCoursePic()==null){
            course.setCoursePic("image/R-C.jpg");
        }
        if(x == false){
            flag = courseService.save(course);
        } else {
            return new Result(Code.RENAME,flag);
        }
        temp.imageUrl = null;
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @PutMapping
    public Result update(@RequestBody Course course) throws IOException {
        boolean x = false;
        boolean flag = false;
        String str1 = course.getName();
        String str2;
        List<Course> all = courseService.getAllExcepte(course.getId());
        for (int i = 0;i < all.size();i++){
            Course course1 = all.get(i);
            str2 = course1.getName();
            str1 = new String(str1.getBytes("ISO-8859-1"),"UTF-8");
            str2 = new String(str2.getBytes("ISO-8859-1"),"UTF-8");
            if (str1.equals(str2)){
                x = true;
                break;
            }
        }
        course.setCoursePic(temp.imageUrl);
        if(x == false){
            flag = courseService.update(course);
        } else {
            return new Result(Code.RENAME,flag);
        }
        temp.imageUrl = null;
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = courseService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Course course = courseService.getById(id);
        Integer code = course != null ? Code.GET_OK : Code.GET_ERR;
        String msg = course !=null ? "" : "数据查询失败，请重试!";
        return new Result(code, course,msg);
    }

    @GetMapping
    public Result getAll() {
        List<Course> courseList = courseService.getAll();;
        Integer code = courseList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = courseList !=null ? "" : "数据查询失败，请重试!";
        return new Result(code, courseList,msg);
    }
}
