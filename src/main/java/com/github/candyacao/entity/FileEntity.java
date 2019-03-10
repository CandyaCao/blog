package com.github.candyacao.entity;

import com.github.candyacao.config.Config;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileEntity {
    private String id;
    private String name;
    // 不包含basepath的路径部分
    private String path;

    public FileEntity() {
    }

    public FileEntity(String id, String name, String path) {
        this.id = id;
        this.name = name;
        this.path = path;
    }

    // 很丑的不序列化 getInputStream 的方式
    public InputStream InputStream() {
        Path path = Paths.get(Config.BASEPATH, this.path);
        InputStream is = null;
        try {
            is = new FileInputStream(path.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return is;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
