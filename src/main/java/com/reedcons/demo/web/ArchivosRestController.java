package com.reedcons.demo.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.reedcons.demo.business.BusinessException;
import com.reedcons.demo.business.IArchivoBusiness;
import com.reedcons.demo.model.Archivo;
import com.reedcons.demo.model.exception.NotFoundException;

@RestController
@RequestMapping(Constantes.URL_ARCHIVOS)
public class ArchivosRestController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IArchivoBusiness archivoBusiness;

	// /api/v1/archivos/fs/
	@PostMapping(value = { "/fs", "/fs/" })
	public ResponseEntity<Archivo> uploadFS(@RequestParam("file") MultipartFile file) {
		Archivo r;
		try {
			r = archivoBusiness.saveToFS(file);
			r.setDownloadUri(Constantes.URL_ARCHIVOS + "/fs/" + r.getNombre());
			HttpHeaders headers = new HttpHeaders();
			headers.add("location", r.getDownloadUri());
			return new ResponseEntity<Archivo>(r, headers, HttpStatus.CREATED);
			//return  ResponseEntity.status(HttpStatus.CREATED.value()).headers(headers).body(r);
		} catch (BusinessException e) {
			return new ResponseEntity<Archivo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/fs/{fileName:.+}")
	public ResponseEntity<Resource> downloadFS(@PathVariable("fileName") String fileName, HttpServletRequest request) {
		Resource resource;

		try {
			resource=archivoBusiness.loadFromFS(fileName);
		} catch (BusinessException e) {
			return new ResponseEntity<Resource>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NotFoundException e) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		
		String mime = null;
		try {
			mime=request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException e) {
			
		}
		if(mime==null) {
			mime="application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(mime))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

}
