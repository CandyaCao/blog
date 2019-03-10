package com.github.candyacao.service.impl;

import com.github.candyacao.config.Config;
import com.github.candyacao.entity.FileEntity;
import com.github.candyacao.mapper.FileMapper;
import com.github.candyacao.service.FileService;
import com.github.candyacao.utils.Misc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileMapper fileMapper;

    public List<FileEntity> saveFileToPath(List<MultipartFile> files) {
        List<FileEntity> ret = new ArrayList<>();
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            File dest;
            FileEntity fe = new FileEntity();
            fe.setId(Misc.UUID());
            int randomTimes = 0;
            do {
                fileName = Misc.UUID() + fileName;
                Path path = Paths.get(Config.BASEPATH, fileName);
                dest = new File(path.toString());
                randomTimes++;
            } while (dest.exists() && randomTimes < 5);

            if (randomTimes > 5) {
                continue;
            }

            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdir();
            }

            try {
                file.transferTo(dest);
                fe.setName(fileName);
                fe.setPath(fileName);
                ret.add(fe);
            } catch (IOException e) {
                // LOG: continue loop
            }
        }
        return ret;
    }

    @Override
    public List<FileEntity> saveFile(List<MultipartFile> files) {
        List<FileEntity> fileEntitys = saveFileToPath(files);
        List<FileEntity> ret = new ArrayList<>();
        for (FileEntity fe : fileEntitys) {
            if (fileMapper.saveFile(fe) > 0) {
                ret.add(fe);
            }
        }
        return ret;
    }

    @Override
    public FileEntity getFile(String id) {
        return fileMapper.getFile(id);
    }
}
