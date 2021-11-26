package id.actualtraining.restwithjpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String age;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinTable(name = "student_course",joinColumns = {@JoinColumn(name = "student_id",referencedColumnName = "id",nullable = false,updatable = false)},
    inverseJoinColumns = {@JoinColumn(name = "course_id",referencedColumnName = "id",
    nullable = false,updatable = false)})
    @JsonIgnore
    private Set<Course> courses = new HashSet<>();
}
