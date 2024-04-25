package com.info.Service.Impl;

import com.info.Entity.IdProof;
import com.info.Payload.IdProofDTO;
import com.info.Repository.IdProofRepository;
import com.info.Service.IdProofService;
import org.springframework.stereotype.Service;

@Service
public class IdProofimpl implements IdProofService {
    private IdProofRepository idProofRepository;

    public IdProofimpl(IdProofRepository idProofRepository) {
        this.idProofRepository = idProofRepository;
    }
    @Override
    public IdProofDTO updateIdProofById(long id, IdProofDTO idProofDTO) {
        IdProof idProof = idProofRepository.findById(id).orElseThrow(null);
        idProof.setPanCardNumber(idProofDTO.getPanCardNumber());
        IdProof saved = idProofRepository.save(idProof);
        IdProofDTO idProofDTO1=new IdProofDTO();
        idProofDTO1.setPanCardNumber(idProof.getPanCardNumber());
        return idProofDTO1;
    }
    @Override
    public void DeletedIdproofById(long id) {
        idProofRepository.findById(id).orElseThrow(null);
        idProofRepository.deleteById(id);
    }

    //Convert DTO to Entity
    public IdProof mapToEntity(IdProofDTO idProofDTO){
        IdProof idProof=new IdProof();

        idProof.setPanCardNumber(idProofDTO.getPanCardNumber());
        return idProof;
    }
    //Convert Entity to DTO
    public IdProofDTO mapToDTO(IdProof idProof){
        IdProofDTO idProofDTO=new IdProofDTO();
        idProofDTO.setPanCardNumber(idProof.getPanCardNumber());
        return idProofDTO;
    }
}
