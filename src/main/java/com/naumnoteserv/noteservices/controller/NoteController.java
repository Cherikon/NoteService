package com.naumnoteserv.noteservices.controller;


import com.naumnoteserv.noteservices.model.Note;
import com.naumnoteserv.noteservices.repository.NoteRepository;
import com.naumnoteserv.noteservices.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService){
        this.noteService=noteService;
    }

    @GetMapping(value = "/noteList")
    public ModelAndView showNotes() {
        List<Note> notes = noteService.readAll();
        Map<String, Object> params = new HashMap<>();
        params.put("notes", notes);
        return new ModelAndView("noteList", params);
    }
    @GetMapping(value = "/note/{id}")
    public ModelAndView showNote(@PathVariable Integer id){
        Note note = noteService.read(id);
        Map<String, Object> params = new HashMap<>();
        params.put("note", note);
        return new ModelAndView("Note", params);
    }
    /*@PostMapping(value = "/create")
    public ResponseEntity<Boolean> create(@RequestBody Note note){
        noteService.create(note);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }*/
    @GetMapping(value = "/create")
    public ModelAndView showCreate() {
        List<Note> notes = noteService.readAll();
        Map<String, Object> params = new HashMap<>();
        params.put("notes", notes);
        return new ModelAndView("create", params);
    }
    @PostMapping(value = "/create")
    public ModelAndView saveCreate(@RequestBody Note note) {
        //Note note = new Note();
        //model.addAttribute("note", note);
        noteService.create(note);
        return new ModelAndView("noteList");
    }
    @DeleteMapping(value = "/delete/{id}")
    public ModelAndView  delete(@PathVariable Integer id) {
        noteService.delete(id);
        return new ModelAndView("noteList");
    }

}
