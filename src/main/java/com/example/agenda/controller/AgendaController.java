package com.example.agenda.controller;

import com.example.agenda.service.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
@RequiredArgsConstructor
public class AgendaController {
    private final AgendaService service;

    @PostMapping("/agenda")
    public ResponseEntity<?> saveAgenda(@RequestBody AgendaDTO person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createdPerson(person));
    }

    @PutMapping("/agenda/{id}")
    public ResponseEntity<?> updateAgenda(@PathVariable String id, @RequestBody AgendaDTO dto) {
        AgendaDTO updating = service.updatePerson(id, dto);
        if (updating == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updating);
        }
    }

    @DeleteMapping("/agenda/{id}")
    public ResponseEntity<?> deleteAgenda(@PathVariable String id) {
        if (service.exist(id)) {
            service.deleteAgendaById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/agenda")
    public ResponseEntity<?> deleteAllAgenda() {
        if (service.count() > 0) {
            service.deleteAllAgenda();
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/agenda")
    public ResponseEntity<?> getAllAgenda() {
        List<AgendaDTO> lista = service.getPersons();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/agenda/{id}")
    public ResponseEntity<?> getAgendaById(@PathVariable String id) {
        AgendaDTO dto = service.getById(id);

        if(dto == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(dto);
        }
    }
}
