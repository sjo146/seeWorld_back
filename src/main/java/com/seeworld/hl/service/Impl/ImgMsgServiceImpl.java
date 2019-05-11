package com.seeworld.hl.service.Impl;
import com.seeworld.hl.dao.ImgMsgMapper;
import com.seeworld.hl.domain.ImgMsg;
import com.seeworld.hl.service.ImgMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class ImgMsgServiceImpl implements ImgMsgService {

    private ImgMsgMapper imgMsgMapper;

    @Autowired
    ImgMsgServiceImpl(ImgMsgMapper imgMsgMapper) {
        this.imgMsgMapper = imgMsgMapper;
    }

    @Override
    public int addImg(ImgMsg img,int pid) {
        System.out.println("now addImg");
        return imgMsgMapper.addImg(img,pid);
    }

    @Override
    public byte[] SaveImage(String path) {
        BASE64Encoder encoder = new sun.misc.BASE64Encoder();
        File f = new File(path);
        BufferedImage bi;
        try {
            bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            byte[] bytes = baos.toByteArray();
            return  encoder.encodeBuffer(bytes).trim().getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteImg(int imgID) {
        int result=imgMsgMapper.deleteImg(imgID);
        if(result==1)
        {
            return true;
        }
        return false;
    }

    @Override
    public ImgMsg getImgByImgId(int id) {
        ImgMsg imgMsg=imgMsgMapper.selectImgByImgId(id);
        System.out.println(id+"----------"+imgMsg.getImgDesc());
        return imgMsg;
    }

    @Override
    public ImgMsg updateImg(ImgMsg imgMsg) {
        imgMsgMapper.updateImg(imgMsg);
        return imgMsgMapper.selectImgByImgId(imgMsg.getImgId());
    }

    @Override
    public ArrayList<ImgMsg> getAllPicture(int pid){
        ArrayList<ImgMsg> list=imgMsgMapper.getAllPic(pid);
        System.out.println("list.size()="+list.size());
        return list;
    }

}