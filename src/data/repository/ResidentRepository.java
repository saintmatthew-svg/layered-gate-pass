package data.repository;

import data.models.Resident;

import java.util.List;
import java.util.Optional;

public interface ResidentRepository {

    Resident save(Resident resident);
    void delete(Resident resident);
    void delete(long id);
    Optional<Resident> findById(long id);
    Resident findByFullName(String fullName);
    Optional<List<Resident>> findAll();
    long count();
}
