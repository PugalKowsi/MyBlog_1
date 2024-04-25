package com.info.Controller;

import com.info.Entity.IdProof;
import com.info.Payload.IdProofDTO;
import com.info.Service.IdProofService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/idproofs")
public class IdProofController {
    private IdProofService idProofService;
    public IdProofController(IdProofService idProofService) {
        this.idProofService = idProofService;
    }
    @PutMapping("/{id}")
    public ResponseEntity<IdProofDTO>updateIdProofById(@PathVariable("id")long id, @RequestBody IdProofDTO idProofDTO){
        IdProofDTO updateIdproof=idProofService.updateIdProofById(id,idProofDTO);
        return new ResponseEntity<>(updateIdproof,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>DeleteIdproofById(@PathVariable("id")long id){
        idProofService.DeletedIdproofById(id);
        return new ResponseEntity<String>("Unwanted was Deleted IdProof",HttpStatus.OK);
    }
}
