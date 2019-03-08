package com.github.candyacao.mapper;

import com.github.candyacao.entity.FileEntity;

public interface FileMapper {
    int saveFile(FileEntity file);
    FileEntity getFile(String id);
}
