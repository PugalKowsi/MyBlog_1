package com.info.Controller;

import com.info.Payload.IdProofDTO;
import com.info.Payload.StudentAndIdProofDTO;
import com.info.Payload.StudentDTO;
import com.info.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> saveStudentWithIdProof(@RequestBody StudentAndIdProofDTO studentAndIdProofDTO) {
        StudentDTO studentDTO = studentAndIdProofDTO.getStudent();
        IdProofDTO idProofDTO = studentAndIdProofDTO.getIdProof();
        StudentDTO savedStudentDTO = studentService.saveStudentWithIdProof(studentDTO, idProofDTO);
        return ResponseEntity.ok(savedStudentDTO);
    }
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> studentDTOList = studentService.getAllStudents();
        return ResponseEntity.ok(studentDTOList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id")long id) {
        StudentDTO studentDTO = studentService.getStudentById(id);

        if (studentDTO != null) {
            return ResponseEntity.ok(studentDTO);
        } else {
           return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudentById(
            @PathVariable("id") Long id,@RequestBody StudentDTO studentDTO) {
        StudentDTO updatedStudentDTO = studentService.updateStudentById(id,studentDTO);
        if (updatedStudentDTO != null) {
            return ResponseEntity.ok(updatedStudentDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>DeleteStudentById(@PathVariable("id")long id){
        studentService.DeleteStudentById(id);
        return new ResponseEntity<String>("Student was Deleted", HttpStatus.ACCEPTED);
    }
}


