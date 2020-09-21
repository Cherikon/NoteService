package com.naumnoteserv.noteservices.service;

import com.naumnoteserv.noteservices.model.Note;

import java.util.List;

public interface NoteService {

    void create(Note note);
    List<Note> readAll();
    Note read(int id);
    boolean update(Note note, int id);
    boolean delete(int id);
}
