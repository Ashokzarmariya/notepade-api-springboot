package com.eagle.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eagle.model.Note;
import com.eagle.repository.NoteDao;

@Service
public class NoteImplementation implements NoteServices {
	
	@Autowired
	private NoteDao dao;

	@Override
	public Note createNote(Note note) {
		note.setTimestamp(LocalDateTime.now());
		Note createdNote=dao.save(note);
		
		return createdNote;
	}

}
