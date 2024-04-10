package ait.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ait.model.ResponseMessage;
import ait.model.ResumeFile;
import ait.services.ResumeService;




@RestController
@RequestMapping("/api/resume")
public class ResumeController {
	
@Autowired
ResumeService resumeService;
	

	@PostMapping("/upload/{candidateId}")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,@PathVariable Long candidateId) {
	    String message = "";
	    try {
	    	resumeService.store(file,candidateId);
	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }


	@GetMapping("/getallfiles")
	public ResponseEntity<List<ResumeFile>> getFiles(@RequestParam Long candidateId) {
	    try {
	        List<ResumeFile> files = resumeService.getFiles(candidateId);
	        return ResponseEntity.ok(files);
	    } catch (Exception e) {
	        // Handle the exception appropriately (e.g., log it)
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
	
	@GetMapping("/files")
	public ResumeFile getFileById(@RequestParam Long candidateId, @RequestParam Long resumeId) {
	    return resumeService.getFileById(candidateId, resumeId);
	}
	  	
}