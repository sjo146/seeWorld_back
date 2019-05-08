package com.seeworld.hl.service.Impl;
import com.seeworld.hl.dao.ImgMsgMapper;
import com.seeworld.hl.domain.ImgMsg;
import com.seeworld.hl.service.ImgMsgService;
import com.thoughtworks.xstream.persistence.FileStreamStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Service
public class ImgMsgServiceImpl implements ImgMsgService {

    private ImgMsgMapper imgMsgMapper;

    @Autowired
    ImgMsgServiceImpl(ImgMsgMapper imgMsgMapper) {
        this.imgMsgMapper = imgMsgMapper;
    }

    @Override
    public int addImg(ImgMsg img) {
        System.out.println("now addImg");
        return imgMsgMapper.addImg(img);
    }

    @Override
    public byte[] SaveImage(String path) {
        File f = new File(path);
        BufferedImage bi;
        try {
            bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}