package com.eagle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eagle.model.Note;

public interface NoteDao extends JpaRepository<Note, Integer> {
	
	

}
