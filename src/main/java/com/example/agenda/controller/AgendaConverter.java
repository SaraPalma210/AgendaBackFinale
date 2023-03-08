package com.example.agenda.controller;

import com.example.agenda.model.AgendaModel;
import org.modelmapper.ModelMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AgendaConverter {
    private static final ModelMapper mapper = new ModelMapper();
    public AgendaModel convertTo(AgendaDTO agendaDTO) {
        return mapper.map(agendaDTO, AgendaModel.class);
    }
    public AgendaDTO convertToDTO(AgendaModel agendaModel) {
        return mapper.map(agendaModel, AgendaDTO.class);
    }
}
