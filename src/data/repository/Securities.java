package data.repository;

import data.models.Security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Securities implements SecurityRepository {
    private final List<Security> securities = new ArrayList<>();
    @Override
    public Security save(Security security) {
        security.setId(generateId());
        securities.add(security);
        return security;
    }

    private int generateId() {
        return 1;
    }

    @Override
    public void delete(Security security) {
        securities.remove(security);
    }

    @Override
    public void delete(long id) {
        delete(findById(id).get());
    }

    @Override
    public Optional<Security> findById(long id) {
        for(Security security : securities) {
            if(security.getId() == id) {
                return Optional.of(security);
            }
        }
        return Optional.empty();
    }

    @Override
    public Security findByFullName(String fullName) {
        for(Security security : securities) {
            if(security.getFullName().equals(fullName)) {
                return security;
            }
        }
        return null;
    }

    @Override
    public Optional<List<Security>> findAll() {
        return Optional.of(securities);
    }

    @Override
    public long count() {
        return securities.size();
    }
}
