package com.example.agenda.service.impl;

import com.example.agenda.model.AgendaModel;
import com.example.agenda.controller.AgendaDTO;
import com.example.agenda.repository.AgendaRepository;
import com.example.agenda.service.AgendaService;
import com.example.agenda.controller.AgendaConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgendaServiceImpl implements AgendaService {
    private final AgendaRepository conn;
    private final AgendaConverter mapper;
    @Override
    public AgendaDTO createdPerson(AgendaDTO dto) {
        return mapper.convertToDTO(conn.save(mapper.convertTo(dto)));
    }

    @Override
    public List<AgendaDTO> getByLastName(String lastName) {
        return conn.findByLastName(lastName).stream().map(mapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<AgendaDTO> getPersons() {
        return conn.findAll().stream().map(mapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public AgendaDTO getById(String id) {
        AgendaModel agendaModel = conn.findById(id).orElse(null);
        return agendaModel != null ? mapper.convertToDTO(agendaModel) : null;
    }

    @Override
    public AgendaDTO updatePerson(String id, AgendaDTO dto) {
        AgendaModel updating = conn.findById(id).orElse(null);
        if (updating == null) {
            return null;
        } else {
            updating.setFirstName(dto.getFirstName());
            updating.setLastName(dto.getLastName());
            updating.setStreet(dto.getStreet());
            updating.setPostalCode(dto.getPostalCode());
            updating.setCity(dto.getCity());
            updating.setBirthday(dto.getBirthday());
            conn.save(updating);
            return mapper.convertToDTO(updating);
        }
    }

    @Override
    public boolean exist(String id) {
        return conn.existsById(id);
    }

    @Override
    public void deleteAgendaById(String id) {
        conn.deleteById(id);
    }

    @Override
    public long count() {
        return conn.count();
    }

    @Override
    public void deleteAllAgenda() {
        conn.deleteAll();
    }
}
