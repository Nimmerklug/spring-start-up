package org.example.springboot.repository;

import org.example.springboot.entity.Apprentice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprenticeRepository extends JpaRepository<Apprentice, Long> {
    public Apprentice findByFirstNameAndLastName(String firstName, String lastName);

    public List<Apprentice> findByFirstName(String firstName);

    public List<Apprentice> findByFirstNameContaining(String name);

    public List<Apprentice> findByLastNameNotNull();

    public List<Apprentice> findByGuardianName(String guardianName);

    //JPQL - based on classes not tables
    @Query("select a from Apprentice a where a.emailId =?1")
    public Apprentice getApprenticeByEmailAddress(String email);

    //JPQL - based on classes not tables
    @Query("select a.firstName from Apprentice a where a.emailId =:emailId")
    public String getApprenticeFirstNameByEmailAddress(@Param("emailId") String email);

    //NOT JPQL - based on tables
    @Query(value = "select * from apprentices a where a.email_address =:emailId", nativeQuery = true)
    public Apprentice getApprenticeByEmailAddressByNativeQuery(@Param("emailId") String email);

    /*
    @Modifying // require transactional
    @Transactional
    @Query( name ="update apprentices set first_name= ?1 where email_address= ?2" ,nativeQuery = true)
    public int updateApprenticeFirstNameByByEmailAddress(String firstName,String email );*/
}
