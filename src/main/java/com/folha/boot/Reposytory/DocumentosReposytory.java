package com.folha.boot.Reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.folha.boot.domain.Doc;

@Repository
public interface DocumentosReposytory extends JpaRepository<Doc, Long >{

}
