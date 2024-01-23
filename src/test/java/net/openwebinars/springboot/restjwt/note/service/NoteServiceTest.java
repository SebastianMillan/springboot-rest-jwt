package net.openwebinars.springboot.restjwt.note.service;

import net.openwebinars.springboot.restjwt.dto.GetNoteDto;
import net.openwebinars.springboot.restjwt.dto.NotesGroupedByTagsDto;
import net.openwebinars.springboot.restjwt.note.model.Note;
import net.openwebinars.springboot.restjwt.note.repo.NoteRepository;
import net.openwebinars.springboot.restjwt.user.model.User;
import org.aspectj.weaver.ast.Not;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NoteServiceTest {

    @InjectMocks
    NoteService noteService;

    @Mock
    NoteRepository noteRepository;

    @Test
    void notesGroupedByTagsDtoList() {

        User u = User.builder()
                .id(UUID.randomUUID())
                .build();

        Note n1 = Note.builder()
                .id(1L)
                .author(u.getId().toString())
                .title("Comprar en mercadona")
                .tags(List.of("Compra","Comida"))
                .build();

        Note n2 = Note.builder()
                .id(2L)
                .author(u.getId().toString())
                .title("Comprar Smart TV")
                .tags(List.of("Compra","Casa"))
                .build();
        Note n3 = Note.builder()
                .id(3L)
                .author(u.getId().toString())
                .title("Limpiar la cocina")
                .tags(List.of("Casa"))
                .build();

        Mockito.when(noteRepository.findByAuthor(u.getId().toString())).thenReturn(new ArrayList<Note>());

        List<NotesGroupedByTagsDto> expectedResult= List.of(
                new NotesGroupedByTagsDto("Compra", List.of(
                        new GetNoteDto(1L,"Compra en mercadona", null),
                        new GetNoteDto(2L,"Comprar Smart TV", null))),
                new NotesGroupedByTagsDto("Casa", List.of(
                        new GetNoteDto(2L,"Comprar Smart TV", null),
                        new GetNoteDto(3L,"Limpiar la cocina", null))),
                new NotesGroupedByTagsDto("Comida", List.of(
                        new GetNoteDto(1L,"Compra en mercadona", null)
                ))
        );
        List<NotesGroupedByTagsDto> result= noteService.notesGroupedByTagsDtoList(u.getId().toString());

        assertFalse(result.isEmpty());
        assertEquals(result.size(), 3);
        assertEquals(result, expectedResult);

    }
}