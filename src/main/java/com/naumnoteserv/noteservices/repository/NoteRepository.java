package com.naumnoteserv.noteservices.repository;

import com.naumnoteserv.noteservices.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

}
