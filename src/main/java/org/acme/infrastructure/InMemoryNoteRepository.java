package org.acme.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.acme.model.Note;

public class InMemoryNoteRepository implements NoteRepository{

    private List<Note> notes;
    private Long sequence = 0L;

    public InMemoryNoteRepository() {
        notes = new ArrayList<>();

        Note note = new Note();
        note.setId(1L);
        note.setTitle("Some title...");
        note.setContent("Some content...");

        this.create(note);
    }

    @Override
    public List<Note> findAll() {
        return List.copyOf(notes);
    }

    @Override
    public Note create(Note note) {
        Note cloned = note.getClone();
        cloned.setId(++this.sequence);
        notes.add(cloned);
        return cloned.getClone();
    }

    @Override
    public Note update(Long id, Note note) {
        Optional<Note> optionalNote = notes.stream().filter((n) -> n.getId() == id).findFirst();
        if (optionalNote.isEmpty()) return null;
        Note oldNote = optionalNote.get();
        oldNote.setTitle(note.getTitle());
        oldNote.setContent(note.getContent());
        return oldNote.getClone();
    }

    @Override
    public Note delete(Long id) {
        Optional<Note> optionalNote = notes.stream().filter((n) -> n.getId() == id).findFirst();
        if (optionalNote.isEmpty()) return null;
        Note note = optionalNote.get();
        notes.remove(note);
        return note;
    }
    
}
