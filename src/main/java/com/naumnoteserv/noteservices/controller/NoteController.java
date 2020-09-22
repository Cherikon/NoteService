package com.naumnoteserv.noteservices.controller;


import com.naumnoteserv.noteservices.model.Note;
import com.naumnoteserv.noteservices.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class NoteController {


    @Autowired
    private NoteService noteService;

    @GetMapping(value = "/noteList")   //display main page
    public ModelAndView showNotes() {
        List<Note> notes = noteService.readAll();
        Map<String, Object> params = new HashMap<>();
        params.put("notes", notes);
        return new ModelAndView("noteList", params);
    }

    @GetMapping(value = "/note/{id}")   //display a single note page
    public ModelAndView showNote(@PathVariable Integer id) {
        Note note = noteService.find(id);
        Map<String, Object> params = new HashMap<>();
        params.put("note", note);
        return new ModelAndView("Note", params);
    }

    @GetMapping(value = "/create")   //display create page
    public ModelAndView showCreate() {
        List<Note> notes = noteService.readAll();
        Map<String, Object> params = new HashMap<>();
        params.put("notes", notes);
        return new ModelAndView("create", params);
    }

    @PostMapping(value = "/create")  //create new note
    public ModelAndView saveCreate(@RequestBody Note note) {
        noteService.create(note);
        return new ModelAndView("noteList");
    }

    @DeleteMapping(value = "/delete/{id}")  //delete selected note
    public ModelAndView delete(@PathVariable Integer id) {
        noteService.delete(id);
        return new ModelAndView("noteList");
    }

}
