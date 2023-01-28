package org.acme.infrastructure;

import java.util.List;

import org.acme.model.Note;

public interface NoteRepository {
    List<Note> findAll();
    Note create(Note note);
    Note update(Long id, Note note);
    Note delete(Long id);
}
