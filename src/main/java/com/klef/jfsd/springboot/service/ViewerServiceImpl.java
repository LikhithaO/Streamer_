package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Viewer;
import com.klef.jfsd.springboot.repository.ViewerRepository;


@Service
public class ViewerServiceImpl implements ViewerService{

	@Autowired
	private ViewerRepository viewerRepository;
	
	@Override
	public String addviewer(Viewer v) {
		viewerRepository.save(v);
		return "Viewer Saved Successfully";
	}

	@Override
	public Viewer checklogin(String username, String pwd) {
		return viewerRepository.checklogin(username, pwd);
	}

}
