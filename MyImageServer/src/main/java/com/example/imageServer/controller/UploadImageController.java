package com.example.imageServer.controller;


import com.example.imageServer.util.FileNameUtil;
import com.example.imageServer.util.FileUploadUtil;
import com.example.imageServer.util.Response;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
public class UploadImageController {
    @GetMapping("/test")
    public String test(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test";
    }

//    @ApiOperation("图片上传")
//    @ApiImplicitParam(name = "file", value = "文件", required = true, dataType = "File")
    @RequestMapping(value="/upload",method= {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Response upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        //定义要上传文件 的存放路径
//        String localPath="F:/blog-images/";
        String localPath="/www/myProject/images/";
        //获得文件名字
        String fileName=file.getOriginalFilename();
        fileName= FileNameUtil.getFileName(fileName);
        File dest = new File(localPath + fileName);
        if(FileUploadUtil.upload(file, localPath, fileName)){
            // 将上传的文件写入到服务器端文件夹
            // 获取当前项目运气的完整url
            String requestURL = request.getRequestURL().toString();
            // 获取当前项目的请求路径url
            String requestURI = request.getRequestURI();
            // 得到去掉了uri的路径
            String url = requestURL.substring(0, requestURL.length()-requestURI.length() + 1);
            url="images/"+ fileName;

            return Response.okMap("url",url);

//            return  ResultUtil.success(url);

        }
        // 返回
        return Response.fail("fail");
//        return ResultUtil.error(202,"未知错误导致上传失败");
    }
}
