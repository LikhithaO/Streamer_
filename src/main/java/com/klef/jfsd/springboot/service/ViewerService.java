package com.klef.jfsd.springboot.service;

import com.klef.jfsd.springboot.model.Viewer;

public interface ViewerService{
	public String addviewer(Viewer v);
	public Viewer checklogin(String username,String pwd);
}
