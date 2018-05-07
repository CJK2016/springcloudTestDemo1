package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.student;

public interface studentDao extends JpaRepository<student, Integer>, JpaSpecificationExecutor<student>{
//public interface studentDao extends JpaRepository<student, Integer>, JpaSpecificationExecutor<student>{

	/**
	 * JpaSpecificationExecutor 这个接口里面才可以动态条件查询
	 * 继承这个是为了动态查询Specification 使用
	 * 
	 * nativeQuery默认是hql查询，这里true表示使用本地查询，就是原生的sql方式
	 * 
	 * 动态查询Specification 使用
	          什么时候用呢？比如搜索有很多条件，有时候用户只填了一个，有时候填很多，不确定条件的数目，这时候动态判断，拼接sql，使用Specification
	 */
	@Query(value="select * from student s where s.name like %?1%", nativeQuery=true)
    public List<student> findByName(String name);
    
    
    /**
     * SpringBoot中使用Spring Data Jpa 实现简单的动态查询的两种方法:
     * 第一种方式：通过JPA的Criteria API实现
     * 第二种方式：DAO层接口实现JpaSpecificationExecutor<T>接口
     */
   
    
}
