package com.tecsinfo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecsinfo.entities.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

	List<Rol> findAll();

}
