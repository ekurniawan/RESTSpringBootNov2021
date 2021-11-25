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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int modules;
    private double fee;

    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
    private Set<Student> students = new HashSet<>();
}
