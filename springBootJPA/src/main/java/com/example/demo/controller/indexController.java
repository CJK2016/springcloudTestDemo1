package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.student;
import com.example.demo.service.studentService;

@RestController
@RequestMapping("/index")
public class indexController {

	@Autowired
	private studentService stuService;
	
	@RequestMapping("/index")
	public String index(){
		return "hello this is the index controller";
	}
	
	/**
	 * 返回到页面中
	 * @return
	 */
	@RequestMapping("/toIndex")
	public ModelAndView toIndex(){
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	
	@RequestMapping(value="/toIndex2")
	public String toIndex2(){
		return "index";
	}
	@RequestMapping(value = "/toIndex3",method = RequestMethod.GET)
	public String toIndex3(){
		return "index";
	}
	
	/**
	 * 测试 json
     * springboot默认使用的json解析框架是jackson;
     * @return
     */
    @RequestMapping("/getStudent")
    public student getStudent(){
        student student = new student();
        student.setAge(20);
        student.setName("测试用户");
        student.setId(233);
        return student;
    }
	
    /**
     * 数据库查询全部
     * @return
     */
	@RequestMapping("/queryStudentAll")
	public List queryStudentAll(){
		List<student> stuList = stuService.StudentAll();
		for (student student : stuList) {
			System.out.println(student.getName());
		}
		return stuList;
	}
	
	/**
	 * 数据库根据指定名称查询相应数据
	 * @return
	 */
	@RequestMapping("/queryStudentByName")
	public List queryStudentByName(){
		List<student> stuList = stuService.StudentName("zhang");
		System.out.println(stuList.size());
		for (student student : stuList) {
			System.out.println(student.getName());
		}
		return stuList;
	}
	
}
