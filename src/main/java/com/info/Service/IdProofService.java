package com.info.Service;

import com.info.Payload.IdProofDTO;

public interface IdProofService {
    IdProofDTO updateIdProofById(long id, IdProofDTO idProofDTO);
    void DeletedIdproofById(long id);
}
