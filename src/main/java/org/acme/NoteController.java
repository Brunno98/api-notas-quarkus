package org.acme;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.infrastructure.InMemoryNoteRepository;
import org.acme.infrastructure.NoteRepository;
import org.acme.model.Note;

@Path("/note")
public class NoteController {
    
    private NoteRepository noteRepository;

    public NoteController() {
        this.noteRepository = new InMemoryNoteRepository();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Note create(Note note) {
        return noteRepository.create(note);
    }

    @PUT
    @Path("{id}")
    public Note update(@PathParam("id") Long id, Note note) {
        return noteRepository.update(id, note);
    }

    @DELETE
    @Path("{id}")
    public Note delete(@PathParam("id") Long id) {
        return noteRepository.delete(id);
    }

}
