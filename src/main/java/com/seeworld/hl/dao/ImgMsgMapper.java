package com.seeworld.hl.dao;

import com.seeworld.hl.domain.ImgMsg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
@Mapper
public interface ImgMsgMapper {
@Select("select* from ImgMsg")
    ArrayList<ImgMsg> findAllImgMsg();
    @Insert("insert into ImgMsg(img_type,img_title,img_desc,img_asset_name,img_resource_name) values (#{ImgType},#{ImgTitle},#{ImgDesc},#{ImgAssetName},#{ImgResourceName})")
    @Options(useGeneratedKeys = true,keyProperty = "ImgId",keyColumn = "img_id")
    int addImg(ImgMsg img);
}
