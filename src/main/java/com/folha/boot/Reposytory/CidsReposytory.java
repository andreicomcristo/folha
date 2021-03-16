package com.folha.boot.Reposytory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.folha.boot.domain.Cids;

@Repository
public interface CidsReposytory extends JpaRepository<Cids, Long> {

	public List<Cids> findAllByOrderByCodCidAsc();

	public List<Cids> findByCodCidContainingOrderByCodCidAsc(String codCid);
}
