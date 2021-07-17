package com.folha.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.folha.boot.Reposytory.DocumentosReposytory;
import com.folha.boot.domain.Doc;

@Service
public class DocStorageService {
	@Autowired
	private DocumentosReposytory docReposytory;

	public Doc saveFile(MultipartFile file) {
		String docName = file.getOriginalFilename();

		try {
			Doc doc = new Doc(docName, file.getContentType(), file.getBytes());
			return docReposytory.save(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Optional<Doc> getFile(Long id) {
		return docReposytory.findById(id);
	}

	public List<Doc> getFiles() {
		return docReposytory.findAll();
	}
}
