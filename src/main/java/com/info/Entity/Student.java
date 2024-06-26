package com.info.Entity;

import com.info.Entity.IdProof;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String course;
    private double fee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_student_id",referencedColumnName = "id")
    private IdProof idProof;

}

