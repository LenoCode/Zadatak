package org.test.test.services.domain.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.test.test.domain.dao.FileUploadDao;
import org.test.test.domain.repository.FileUploadRepository;
import org.test.test.rest.dto.request.FileUploadDto;
import org.test.test.rest.dto.response.FileUploadResponseDto;
import org.test.test.services.domain.FileUploadService;

import java.util.ArrayList;
import java.util.List;


@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private FileUploadRepository fileUploadRepository;


    @Override
    public FileUploadResponseDto uploadFile(FileUploadDto fileUploadDto, MultipartFile file) throws Exception {
        checkPayloadDto(fileUploadDto);

        FileUploadDao fileUploadDao = new FileUploadDao();
        fileUploadDao.setName(fileUploadDto.getName());
        fileUploadDao.setLastname(fileUploadDto.getLastname());
        fileUploadDao.setFilename(file.getOriginalFilename());
        fileUploadDao.setTimestamp(fileUploadDto.getCreateTime());
        fileUploadDao.setBytes(file.getBytes());
        fileUploadRepository.save(fileUploadDao);

        return new FileUploadResponseDto(true,"Saved");
    }





    public boolean checkPayloadDto(FileUploadDto fileUploadDto) throws Exception {
        List<String> errors = new ArrayList<>();
        if(fileUploadDto.getName() == null){
            errors.add("Name cannot be null\n");
        }else if(fileUploadDto.getLastname() == null){
            errors.add("Lastname cannot be null\n");
        }else if(fileUploadDto.getCreateTime() == null){
            errors.add("Create time cannot be null\n");
        }
        if(errors.isEmpty())
            return true;
        else
            throw new Exception(errors.stream().reduce("",(partialResult,str)->partialResult+str));
    }
}
