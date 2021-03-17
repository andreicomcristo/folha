package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.folha.boot.domain.FaixasImpostoDeRenda;

public interface FaixasImpostoDeRendaReposytory extends JpaRepository< FaixasImpostoDeRenda , Long> {
   
}
