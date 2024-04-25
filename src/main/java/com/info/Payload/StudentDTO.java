package com.info.Payload;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String name;
    private String course;
    private double fee;
    private IdProofDTO idProof;

}
