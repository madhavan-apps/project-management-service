package com.proj.mgmt.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proj.mgmt.entity.Project;
import com.proj.mgmt.entity.key.ProjectKey;

@Repository
public interface ProjectRepo extends JpaRepository<Project, ProjectKey>{

}
