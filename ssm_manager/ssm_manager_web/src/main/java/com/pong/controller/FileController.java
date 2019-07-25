package com.pong.controller;


import com.pong.fastDFS.fastDFSClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileController {

    @RequestMapping(value = "uploadfile",method  = RequestMethod.POST)
    @ResponseBody
    public String fileupload(@RequestParam MultipartFile uploadfile) throws IOException {

        String fileId =  fastDFSClient.uploadFile(uploadfile.getInputStream(), uploadfile.getOriginalFilename());
        if (fileId != null)
        System.out.println("上传成功");

       return fileId ;
    }
}
