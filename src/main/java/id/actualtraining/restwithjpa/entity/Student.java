package id.actualtraining.restwithjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
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
    private Set<Course> courses = new HashSet<>();
}
