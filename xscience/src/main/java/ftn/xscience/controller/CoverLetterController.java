package ftn.xscience.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coverletter")
public class CoverLetterController {

	@GetMapping(value = "/{id}", produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<?> getCoverLetterById(@PathVariable("id") String id) {
		return null;
	}
	
	@PostMapping(consumes = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<?> uploadCoverLetter(@RequestBody String coverLetter) {
		return null;
	}
}
