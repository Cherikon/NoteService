package com.naumnoteserv.noteservices.service;

import com.naumnoteserv.noteservices.model.Note;
import com.naumnoteserv.noteservices.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public void create(Note note) {
        noteRepository.save(note);
    }

    @Override
    public List<Note> readAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note find(int id) {
        return noteRepository.getOne(id);
    }

    @Override
    public boolean update(Note note, int id) {
        if (noteRepository.existsById(id)) {
            note.setId(id);
            noteRepository.save(note);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
