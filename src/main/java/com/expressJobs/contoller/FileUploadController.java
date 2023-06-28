package com.expressJobs.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.expressJobs.models.UploadResponse;
import com.expressJobs.services.FileStorageService;

@RestController
@RequestMapping("/api/image")
public class FileUploadController {

  private final FileStorageService fileStorageService;

  public FileUploadController(FileStorageService fileStorageService) {
    this.fileStorageService = fileStorageService;
  }

  @PostMapping("/upload")
  public ResponseEntity<UploadResponse> uploadFile(
      @RequestBody MultipartFile file,
      @RequestParam("fullName") String fullName,
      @RequestParam("dateOfBirth") String dateOfBirth
  ) {
      String fileName = fileStorageService.storeFile(file);

      UploadResponse uploadResponse = new UploadResponse(fileName, fullName, dateOfBirth);

      return ResponseEntity.ok().body(uploadResponse);
  }
}