package com.github.candyacao.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class FileUploadAndDownload {
    /**
     * 上传单个文件
     *
     * @param file
     * @return
     */
    @RequestMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        //判断文件是否为空
        if (file.isEmpty()) {
            return "-1";
        }

        String fileName = file.getOriginalFilename();

        //加个时间戳，尽量避免文件名称重复
        String path = "D:/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        File dest = new File(path);

        //判断文件是否已经存在
        if (dest.exists()) {
            return "-2";
        }

        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }

        try {
            file.transferTo(dest); //保存文件
        } catch (IOException e) {
            return "-3";
        }

        return "0";
    }

    /**
     * 上传多个文件
     * @param files
     * @return
     */
    @RequestMapping("/uploadMultifile")
    @ResponseBody
    public String keywordSubmitFile(@RequestParam("file") List<MultipartFile> files) {
        for (MultipartFile file : files) {
            //这里简单输出文件名称
            System.out.println(file.getOriginalFilename());
        }
        return "0";
    }

    /**
     * 下载文件
     * @param response
     * @param filePathName
     * @return
     */
    @RequestMapping("/downloadFile")
    @ResponseBody
    public String downloadFile(HttpServletResponse response, @RequestParam("fileName") String filePathName) {
        File file = new File(filePathName);
        if (!file.exists()) {
            return "-1";
        }

        response.reset();
        response.setHeader("Content-Disposition", "attachment;fileName=" + filePathName);

        try {
            InputStream inStream = new FileInputStream(filePathName);
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
