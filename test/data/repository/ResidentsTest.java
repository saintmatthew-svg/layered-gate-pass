package data.repository;

import data.models.Resident;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class ResidentsTest {
    ResidentRepository residents;

    @BeforeEach
    public void setUp() {
        residents = new Residents();
    }

    @Test
    public void testResidentsIsZero() {
        Assertions.assertEquals(0, residents.count());

    }

    @Test
    public void testResidentCanSave() {
        residents.save(new Resident());
        Assertions.assertEquals(1, residents.count());
        residents.save(new Resident());
        Assertions.assertEquals(2, residents.count());
    }

    @Test
    public void testResidentCanBeFoundById() {
        Resident resident = new Resident();
        Resident savedResident = residents.save(resident);
        Resident foundResident = residents.findById(savedResident.getId()).get();
        Assertions.assertEquals(savedResident, foundResident);
    }

    @Test
    public void testResidentCanDeleteThroughResidentsObject() {
        Resident resident = new Resident();
        Resident savedResident = residents.save(resident);
        residents.delete(savedResident);
        Assertions.assertEquals(0, residents.count());
    }

    @Test
    public void testResidentCanDeleteThroughId() {
        Resident resident = new Resident();
        Resident savedResident = residents.save(resident);
        residents.delete(savedResident.getId());
        Assertions.assertEquals(0, residents.count());
    }

    @Test
    public void testResidentCanBeFoundByFullName() {
        Resident resident = new Resident();
        resident.setFullName("Saint Matthew");
        residents.save(resident);
        Resident foundResident = residents.findByFullName("Saint Matthew");
        Assertions.assertEquals(resident, foundResident);
    }

    @Test
    public void testResidentsCanBeFoundAll() {
        Resident firstResident = new Resident();
        firstResident.setFullName("Saint Matthew");
        residents.save(firstResident);
        Resident secondResident = new Resident();
        secondResident.setFullName("Saint Matthew");
        residents.save(secondResident);
        Optional<List<Resident>> findAll = residents.findAll();
        Assertions.assertEquals(2, findAll.get().size());
        Resident thirdResident = new Resident();
        thirdResident.setFullName("Saint Matthew");
        residents.save(thirdResident);
        findAll = residents.findAll();
        Assertions.assertEquals(3, findAll.get().size());
        Resident fourthResident = new Resident();
        fourthResident.setFullName("Saint Matthew");
        residents.save(fourthResident);
        findAll = residents.findAll();
        Assertions.assertEquals(4, findAll.get().size());
    }
}