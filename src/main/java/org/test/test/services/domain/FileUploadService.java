package org.test.test.services.domain;

import org.springframework.web.multipart.MultipartFile;
import org.test.test.rest.dto.request.FileUploadDto;
import org.test.test.rest.dto.response.FileUploadResponseDto;

public interface FileUploadService {



    FileUploadResponseDto uploadFile(FileUploadDto fileUploadDto, MultipartFile file) throws Exception;



}
