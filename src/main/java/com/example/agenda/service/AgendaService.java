package com.example.agenda.service;

import com.example.agenda.controller.AgendaDTO;

import java.util.List;

public interface AgendaService {

    AgendaDTO createdPerson(AgendaDTO dto);

    List<AgendaDTO> getByLastName(String lastName);

    List<AgendaDTO> getPersons();

    AgendaDTO getById(String id);

    AgendaDTO updatePerson(String id, AgendaDTO dto);

    boolean exist(String id);

    void deleteAgendaById(String id);

    long count();

    void deleteAllAgenda();

}
