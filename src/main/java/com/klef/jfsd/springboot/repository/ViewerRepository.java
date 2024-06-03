package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Viewer;

@Repository
public interface ViewerRepository extends JpaRepository<Viewer, Integer> 
{
	@Query("select e from Viewer e where e.username=?1 and e.password=?2")
	public Viewer checklogin(String username, String pwd);
}
