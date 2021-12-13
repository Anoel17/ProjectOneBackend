package main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
	
	Optional<FileDB> findById(String id);

}
	

