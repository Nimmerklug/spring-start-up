package org.example.springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data //equivallent to @Getter @Setter @RequiredArgsConstructor @ToString @Equals and @Hascode
@NoArgsConstructor // public Location() {} default constructor
@AllArgsConstructor
//constructor with all parameters public Location(Long locationID, String locationName, String locationAddress, String locationCode) {
@Builder // Builder pattern
@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationID;
    @NotBlank(message = "Location Name Couldn't be Empty")
    @Length(min = 3, max = 32, message = "Location Name should be between 3 and 32 characters")
    private String locationName;
    private String locationAddress;
    private String locationCode;
}