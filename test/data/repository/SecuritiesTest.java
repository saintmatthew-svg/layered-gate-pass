package data.repository;

import data.models.Security;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class SecuritiesTest {

    SecurityRepository securities;

    @BeforeEach
    public void setUp() {
        securities = new Securities();
    }

    @Test
    public void testSecurityIsZero() {
        Assertions.assertEquals(0, securities.count());

    }

    @Test
    public void testSecurityCanSave() {
        securities.save(new Security());
        Assertions.assertEquals(1, securities.count());
        securities.save(new Security());
        Assertions.assertEquals(2, securities.count());
    }

    @Test
    public void testSecurityCanBeFoundById() {
        Security security = new Security();
        Security savedSecurity = securities.save(security);
        Security foundSecurity = securities.findById(savedSecurity.getId()).get();
        Assertions.assertEquals(savedSecurity, foundSecurity);
    }

    @Test
    public void testSecurityCanDeleteThroughResidentsObject() {
        Security resident = new Security();
        Security savedSecurity = securities.save(resident);
        securities.delete(savedSecurity);
        Assertions.assertEquals(0, securities.count());
    }

    @Test
    public void testSecurityCanDeleteThroughId() {
        Security security = new Security();
        Security savedSecurity = securities.save(security);
        securities.delete(savedSecurity.getId());
        Assertions.assertEquals(0, securities.count());
    }

    @Test
    public void testSecurityCanBeFoundByFullName() {
        Security security = new Security();
        security.setFullName("Saint Matthew");
        securities.save(security);
        Security foundSecurity = securities.findByFullName("Saint Matthew");
        Assertions.assertEquals(security, foundSecurity);
    }

    @Test
    public void testSecurityCanBeFoundAll() {
        Security security = new Security();
        security.setFullName("Saint Matthew");
        securities.save(security);
        Security secondSecurity = new Security();
        secondSecurity.setFullName("Saint Matthew");
        securities.save(secondSecurity);
        Optional<List<Security>> findAll = securities.findAll();
        Assertions.assertEquals(2, findAll.get().size());
    }
}