package com.info.Service.Impl;
import com.info.Entity.IdProof;
import com.info.Entity.Student;
import com.info.Payload.IdProofDTO;
import com.info.Payload.StudentDTO;
import com.info.Repository.IdProofRepository;
import com.info.Repository.StudentRepository;
import com.info.Service.StudentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private  StudentRepository studentRepository;
    private IdProofRepository idProofRepository;

    public StudentServiceImpl(StudentRepository studentRepository, IdProofRepository idProofRepository) {
        this.studentRepository = studentRepository;
        this.idProofRepository = idProofRepository;
    }
    @Override
    public StudentDTO saveStudentWithIdProof(StudentDTO studentDTO, IdProofDTO idProofDTO) {
        Student student = mapToEntity(studentDTO, idProofDTO);
        // Save student and idProof entities
        Student savedStudent = studentRepository.save(student);
        // Convert saved Entity to DTO and return
        return convertToDTO(savedStudent);
    }
    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> collect = students.stream().map(student ->convertToDTO(student)).collect(Collectors.toList());
        return collect;
    }
    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            return convertToDTO(student);
        } else {
            return null;
        }
    }

    @Override
    public StudentDTO updateStudentById(Long id, StudentDTO studentDTO) {
        Student student = studentRepository.findById(id).orElseThrow(null);
        student.setName(studentDTO.getName());
        student.setCourse(studentDTO.getCourse());
        student.setFee(studentDTO.getFee());

        Student saved = studentRepository.save(student);
        StudentDTO studentDTO1 = convertToDTO(saved);
        return studentDTO1;
    }

    @Override
    public void DeleteStudentById(long id) {
        studentRepository.findById(id).orElseThrow(null);
        studentRepository.deleteById(id);
    }

    // Convert DTOs to Entities
    private Student mapToEntity(StudentDTO studentDTO,IdProofDTO idProofDTO){
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setCourse(studentDTO.getCourse());
        student.setFee(studentDTO.getFee());

        IdProof idProof = new IdProof();
        idProof.setPanCardNumber(idProofDTO.getPanCardNumber());

        // Establish one-to-one relationship
        student.setIdProof(idProof);
        idProof.setStudent(student);
    return student;
    }
    private StudentDTO convertToDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setCourse(student.getCourse());
        studentDTO.setFee(student.getFee());

        if (student.getIdProof() != null) {
            IdProofDTO idProofDTO = new IdProofDTO();
            idProofDTO.setId(student.getIdProof().getId());
            idProofDTO.setPanCardNumber(student.getIdProof().getPanCardNumber());
            studentDTO.setIdProof(idProofDTO);
        }
        return studentDTO;
    }
}
