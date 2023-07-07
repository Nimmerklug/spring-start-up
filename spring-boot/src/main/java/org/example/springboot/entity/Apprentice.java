package org.example.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //equivallent to @Getter @Setter @RequiredArgsConstructor @ToString @Equals and @Hascode
@NoArgsConstructor // public Location() {} default constructor
@AllArgsConstructor
//constructor with all parameters public Location(Long locationID, String locationName, String locationAddress, String locationCode) {
@Builder // Builder pattern
@Entity
@Table(name = "apprentices",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_email_address",
                columnNames = "email_address"))
public class Apprentice {
    @Id
    @SequenceGenerator(name = "apprentice_sequence", sequenceName = "apprentice_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apprentice_sequence")
    private Long apprenticeId;
    private String firstName;
    private String lastName;
    @Column(name = "email_address", nullable = false)
    private String emailId;

    @Embedded
    private Guardian guardian;
    /*
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;
     */
}
