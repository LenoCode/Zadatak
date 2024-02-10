package org.test.test.rest.api.v1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.test.test.rest.dto.request.FileUploadDto;
import org.test.test.rest.dto.response.FileUploadResponseDto;
import org.test.test.services.domain.FileUploadService;

@RestController
@RequestMapping(value = "api/v1/upload/")
public class FileUploadController {



    @Autowired
    private FileUploadService fileUploadService;


    @PostMapping("/")
    public ResponseEntity<FileUploadResponseDto> upload(@RequestPart("details") FileUploadDto fileUploadDto,@RequestPart("file") MultipartFile file){
      try {
          return ResponseEntity.ok( fileUploadService.uploadFile(fileUploadDto,file));
      }catch (Exception e){
          return ResponseEntity.status(406).body(new FileUploadResponseDto(false,e.getMessage()));
      }
    };


    @PostMapping("/t/")
    public ResponseEntity<FileUploadResponseDto> uploadt(@RequestParam("file") MultipartFile file){
        try {
            return ResponseEntity.ok(new FileUploadResponseDto(true,""));
        }catch (Exception e){
            return ResponseEntity.status(406).body(new FileUploadResponseDto(false,e.getMessage()));
        }
    };



}
