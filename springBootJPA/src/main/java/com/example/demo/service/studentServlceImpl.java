package com.example.demo.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.dao.studentDao;
import com.example.demo.entity.student;


@Service
public class studentServlceImpl implements studentService {

	@Autowired
	private studentDao stuDao;
	
	@Override
	public List StudentAll() {
		return stuDao.findAll();
	}

	@Override
	public List<student> StudentName(String name) {
		return stuDao.findByName(name);
	}

	/*@Override
	public String test() {
		String returnBack = null;
		Specification specification = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
            	
                return null;
            }
        };
		return returnBack;
	}*/

}
