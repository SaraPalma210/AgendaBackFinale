package com.example.agenda.repository;

import com.example.agenda.model.AgendaModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendaRepository extends MongoRepository<AgendaModel, String> {
    List<AgendaModel> findByLastName(String lastName);
}
