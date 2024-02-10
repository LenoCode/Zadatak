package org.test.test.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.test.test.domain.dao.FileUploadDao;

@Repository
public interface FileUploadRepository extends PagingAndSortingRepository<FileUploadDao,Integer>, JpaRepository<FileUploadDao,Integer> {

}
