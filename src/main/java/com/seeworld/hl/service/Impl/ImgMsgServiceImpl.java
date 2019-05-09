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
    public void base64StringToImage(String base64String){
        BASE64Decoder decoder = new sun.misc.BASE64Decoder();
        try {
            byte[] bytes1 = decoder.decodeBuffer(base64String);

            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 =ImageIO.read(bais);
            File w2 = new File("e://QQ.jpg");//可以是jpg,png,gif格式
            ImageIO.write(bi1, "jpg", w2);//不管输出什么格式图片，此处不需改动
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}