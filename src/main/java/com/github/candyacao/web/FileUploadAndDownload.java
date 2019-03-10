package com.github.candyacao.web;

import com.github.candyacao.entity.FileEntity;
import com.github.candyacao.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FileUploadAndDownload {
    @Autowired
    private FileService fileService;

    /**
     * 上传单个文件
     *
     * @param file
     * @return
     */
    @RequestMapping("/uploadFile")
    @ResponseBody
    public ResponseEntity<FileEntity> uploadFile(@RequestParam("file") MultipartFile file) {
        //判断文件是否为空
        if (file.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<MultipartFile> mpfs = new ArrayList<>();
        mpfs.add(file);
        List<FileEntity> fel = fileService.saveFile(mpfs);
        ResponseEntity<FileEntity> ret = new ResponseEntity<>(HttpStatus.OK);
        if (fel.size() > 0) {
            ret = new ResponseEntity<>(fel.get(0),HttpStatus.OK);
        }
        return ret;
    }

    /**
     * 上传多个文件
     *
     * @param files
     * @return
     */
    @RequestMapping("/uploadMultifile")
    @ResponseBody
    public ResponseEntity<List<FileEntity>> keywordSubmitFile(@RequestParam("file") List<MultipartFile> files) {
        List<FileEntity> fes = fileService.saveFile(files);
        return new ResponseEntity<>(fes, HttpStatus.OK);
    }

    /**
     * 下载文件
     *
     * @param response
     * @param id
     * @return
     */
    @RequestMapping("/downloadFile")
    @ResponseBody
    public String downloadFile(HttpServletResponse response, @RequestParam("id") String id) {

        FileEntity fe = fileService.getFile(id);

        response.reset();
        response.setHeader("Content-Disposition", "attachment;fileName=" + fe.getName());

        try {
            InputStream inStream = fe.InputStream();
            OutputStream os = response.getOutputStream();

            byte[] buff = new byte[1024];
            int len = -1;
            while ((len = inStream.read(buff)) > 0) {
                os.write(buff, 0, len);
            }
            os.flush();
            os.close();
            inStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "-2";
        }

        return "0";
    }
}
