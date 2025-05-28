package data.repository;

import data.models.Resident;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Residents implements ResidentRepository {
    private final List<Resident> residents = new ArrayList<>();
    
    @Override
    public Resident save(Resident resident) {
        resident.setId(generateId());
        residents.add(resident);
        return resident;
    }

    private int generateId() {
        return 1;
    }

    @Override
    public void delete(Resident resident) {
        residents.remove(resident);
    }

    @Override
    public void delete(long id) {
        delete(findById(id).get());
    }

    @Override
    public Optional<Resident> findById(long id) {
        for(Resident resident : residents) {
            if(resident.getId() == id) {
                return Optional.of(resident);
            }
        }
        return Optional.empty();
    }

    @Override
    public Resident findByFullName(String fullName) {
        for(Resident resident : residents) {
            if(resident.getFullName().equals(fullName)) {
                return resident;
            }
        }
        return null;
    }

    @Override
    public Optional<List<Resident>> findAll() {
        return Optional.of(residents);
    }

    @Override
    public long count() {
        return residents.size();
    }
}
