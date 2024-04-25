package com.info.Service;

import com.info.Payload.IdProofDTO;
import com.info.Payload.StudentDTO;
import java.util.List;
public interface StudentService {
    public StudentDTO saveStudentWithIdProof(StudentDTO studentDTO, IdProofDTO idProofDTO);
    List<StudentDTO> getAllStudents();
    StudentDTO getStudentById(Long id);
    StudentDTO updateStudentById(Long id, StudentDTO studentDTO);
    void DeleteStudentById(long id);
}
