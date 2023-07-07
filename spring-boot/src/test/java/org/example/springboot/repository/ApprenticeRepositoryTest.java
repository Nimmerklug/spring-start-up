package org.example.springboot.repository;

import org.example.springboot.entity.Apprentice;
import org.example.springboot.entity.Guardian;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // save db operations
//@DataJpaTest //not save db operations (might need mock)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //otherwise give error
@TestMethodOrder(OrderAnnotation.class)
class ApprenticeRepositoryTest {
    @Autowired
    private ApprenticeRepository apprenticeRepository;

    @Test
    @Order(1)
    public void addApprentice() {
        // given - setup or precondition do not need to do manually thanks to TestEntityManager persist
        Apprentice apprentice = Apprentice.builder()
                .emailId("Zack@hotmail.com")
                .firstName("Zack")
                .lastName("Smith")
                //.guardianName("Lucy")
                //.guardianEmail("lucy.yahoo.com")
                //.guardianMobile("+447520662353")
                .build();

        // when - action or the testing
        apprenticeRepository.save(apprentice);

        // then - very output


    }

    @Test
    @Order(2)
    public void addApprenticeWithguardian() {
        // given - setup or precondition do not need to do manually thanks to TestEntityManager persist
        Guardian guardian = Guardian.builder()
                .name("Lucy")
                .email("lucy.yahoo.com")
                .mobile("+447520662353")
                .build();

        Apprentice apprentice = Apprentice.builder()
                .emailId("Shiva@outlook.com")
                .firstName("Shiva")
                .lastName("Wall")
                .guardian(guardian)
                //.guardianName("Lucy")
                //.guardianEmail("lucy.yahoo.com")
                //.guardianMobile("+447520662353")
                .build();

        // when - action or the testing
        apprenticeRepository.save(apprentice);

        // then - very output


    }

    @Test
    @Order(3)
    public void getApprenticeList() {

        System.out.println(apprenticeRepository.findAll());
    }

    @Test
    @Order(4)
    public void getApprenticeByFirstName() {

        System.out.println(apprenticeRepository.findByFirstName("Shiva"));
    }

    @Test
    @Order(5)
    public void getApprenticeByFirstNameContaining() {

        System.out.println(apprenticeRepository.findByFirstNameContaining("a"));
    }

    @Test
    @Order(6)
    public void getApprenticeByGuardianName() {

        System.out.println(apprenticeRepository.findByGuardianName("Lucy"));
    }

    @Test
    @Order(7)
    public void getApprenticeByEmailAddress() {

        System.out.println(apprenticeRepository.getApprenticeByEmailAddress("Zack@hotmail.com"));
    }

    @Test
    @Order(7)
    public void getApprenticeFirstNameByEmailAddress() {

        System.out.println(apprenticeRepository.getApprenticeFirstNameByEmailAddress("Zack@hotmail.com"));
    }

    @Test
    @Order(8)
    public void getApprenticeByEmailAddressByNativeQuery() {

        System.out.println(apprenticeRepository.getApprenticeByEmailAddressByNativeQuery("Zack@hotmail.com"));
    }

}