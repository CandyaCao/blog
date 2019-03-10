package com.github.candyacao.service;

import com.github.candyacao.entity.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    List<FileEntity> saveFile(List<MultipartFile> files);
    FileEntity getFile(String id);
}
