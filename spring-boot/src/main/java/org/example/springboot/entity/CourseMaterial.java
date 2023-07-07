package org.example.springboot.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(exclude = "course") //test example for LaZy fetch
public class CourseMaterial {
    @Id
    @SequenceGenerator(name = "course_material_sequence", sequenceName = "course_material_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            //fetch = FetchType.LAZY, // do not fetch Course until you specifically request it
            optional = false //without Course, we cannot save CourseMaterial

    )
    @JoinColumn(name = "cause_id", referencedColumnName = "causeId")
    private Course course;
}
