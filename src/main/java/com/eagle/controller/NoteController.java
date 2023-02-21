package com.eagle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eagle.model.Note;
import com.eagle.services.NoteServices;

@RestController
public class NoteController {
	
	@Autowired
	private NoteServices noteService;
	
	@PostMapping("/notes/create")
	public ResponseEntity<Note> createNoteHandler(@RequestBody Note note){
		
		Note newNote=noteService.createNote(note);
		return new ResponseEntity<Note>(newNote,HttpStatus.CREATED);
		
	}

}
