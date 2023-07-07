package org.example.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Course {
    @Id
    @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private Long causeId;
    private String title;
    private Integer credit;

    @OneToOne(
            mappedBy = "course"
    )
    // no need to do this since in Course Material it is already done @JoinColumn(name ="cause_material_id" ,referencedColumnName = "causeMaterialId")
    private CourseMaterial courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "apprentice_course_map",
            joinColumns = @JoinColumn(name = "cause_id", referencedColumnName = "causeId"),
            inverseJoinColumns = @JoinColumn(name = "apprentice_id", referencedColumnName = "apprenticeId")
    )
    private List<Apprentice> apprenticeList;

    public void addApprentice(Apprentice apprentice) {
        if (apprenticeList == null) apprenticeList = new ArrayList<>();

        apprenticeList.add(apprentice);
    }
}
