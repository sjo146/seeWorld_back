package com.seeworld.hl.controller;

import com.seeworld.hl.domain.ImgMsg;
import com.seeworld.hl.service.ImgMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class PicUploadController
{
    @Value("${cbs.imagesPath}")
    private String theSetDir; //全局配置文件中设置的图片的路径
    private ImgMsgService imgMsgService;
    @Autowired
    PicUploadController(ImgMsgService imgMsgService) {
        this.imgMsgService = imgMsgService;
    }

    @GetMapping("/{page}")
    public String toPate(@PathVariable("page") String page)
    {
        return page;
    }
    @RequestMapping(value = "/fileUploadController")
    public String fileUpload(HttpServletRequest request,MultipartFile filename, Model model) throws Exception
    {
        System.out.println("now the TestController");
        String parentDirPath = theSetDir;//.substring(theSetDir.indexOf(':')+1, theSetDir.length()); //通过设置的那个字符串获得存放图片的目录路径
        System.out.println("parentDirPath="+parentDirPath);
        String title=request.getParameter("title");
        String desc=request.getParameter("desc");
        ImgMsg img=new ImgMsg();
        System.out.println("title="+title);
        System.out.println("desc="+desc);
        String fileName = filename.getOriginalFilename();
        System.out.println("fileName="+fileName);
        File parentDir = new File(parentDirPath);
        if(!parentDir.exists()) //如果那个目录不存在先创建目录
        {
            parentDir.mkdir();
        }

        filename.transferTo(new File(parentDirPath + fileName)); //全局配置文件中配置的目录加上文件名
        String pic_url=parentDirPath+fileName;
        img.set(0,title,desc,pic_url,"0");
        System.out.println("pic_url="+pic_url);
        model.addAttribute("pic_name", fileName);
        model.addAttribute("pic_url",parentDirPath+fileName);
        System.out.println(imgMsgService.addImg(img));

        return "show";
    }
}