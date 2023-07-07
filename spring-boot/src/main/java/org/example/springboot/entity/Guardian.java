package org.example.springboot.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //equivallent to @Getter @Setter @RequiredArgsConstructor @ToString @Equals and @Hascode
@NoArgsConstructor // public Location() {} default constructor
@AllArgsConstructor
//constructor with all parameters public Location(Long locationID, String locationName, String locationAddress, String locationCode) {
@Builder // Builder pattern
@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name = "name", column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name = "email", column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name = "mobile", column = @Column(name = "guardian_mobile")
        )
})
public class Guardian {
    private String name;
    private String email;
    private String mobile;
}
