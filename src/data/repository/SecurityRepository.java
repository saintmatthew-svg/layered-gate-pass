package data.repository;

import data.models.Security;

import java.util.List;
import java.util.Optional;

public interface SecurityRepository {
    Security save(Security security);
    void delete(Security security);
    void delete(long id);
    Optional<Security> findById(long id);
    Security findByFullName(String fullName);
    Optional<List<Security>> findAll();
    long count();
}
