package com.info.Repository;

import com.info.Entity.IdProof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdProofRepository extends JpaRepository<IdProof, Long> {
    // You can add custom query methods if needed
}
