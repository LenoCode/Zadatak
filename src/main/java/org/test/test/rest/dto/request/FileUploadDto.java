package org.test.test.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;



@Getter
@Setter
@AllArgsConstructor
public class FileUploadDto {

    private String name;
    private String lastname;
    private Timestamp createTime;
}
