package com.example.taskHome.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.taskHome.model.Note;
import com.example.taskHome.services.NoteService;

import java.util.List;

/**
 * Контроллер обработки заметок.
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class NoteController {

    private final Counter requestCounter = Metrics.counter("request_count");

    private final NoteService service;

    /**
     * Получение всех заметок.
     * @return ответ со списком заметок.
     */
    @GetMapping()
    public ResponseEntity<List<Note>> allNotes(){
        requestCounter.increment();
        return ResponseEntity.ok().body(service.getAllNotes());
    }

    /**
     * Получение конкретной заметки.
     * @param id идентификатор заметки.
     * @return ответ с заметкой.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getNoteById(id));
    }

    /**
     * Добавление новой заметки.
     * @param note объект заметки.
     * @return ответ с сохраненной заметкой.
     */
    @PostMapping()
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        return ResponseEntity.ok().body(service.createNote(note));
    }

    /**
     * Обновление существующей заметки.
     * @param id идентификатор заметки.
     * @param note объект обновленной заметки.
     * @return ответ с обновленной заметкой.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note){
        return ResponseEntity.ok().body(service.updateNote(id, note));
    }

    /**
     * Удаление заметки.
     * @param id идентификатор заметки.
     * @return ответ со статусом успешного выполнения.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id){
        service.removeNote(id);
        return ResponseEntity.ok().body(null);
    }
}
