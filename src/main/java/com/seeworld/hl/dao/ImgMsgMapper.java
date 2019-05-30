package com.seeworld.hl.dao;

import com.seeworld.hl.domain.ImgMsg;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
@Mapper
public interface ImgMsgMapper {
    @Select("select* from ImgMsg")
    ArrayList<ImgMsg> findAllImgMsg();

    @Select("select ImgMsg.* " +
            "from ImgMsg,Zan " +
            "where ImgMsg.img_id=Zan.imgid and Zan.iszan=1 and Zan.uid=#{uid}")
    ArrayList<ImgMsg> selectZanByUid(int uid);

    @Insert("insert into ImgMsg(img_type,img_title,img_desc,img_asset_name,img_resource_name,p_id) values (#{img.ImgType},#{img.ImgTitle},#{img.ImgDesc},#{img.ImgAssetName},#{img.ImgResourceName},#{pid})")
    @Options(useGeneratedKeys = true, keyProperty = "img.ImgId", keyColumn = "img_id")
    int addImg(ImgMsg img, int pid);

    @Select("select*from ImgMsg where p_id=#{pid}" )
    ArrayList<ImgMsg> getAllPic(int pid);

    @Select("select*from ImgMsg where 4img_id=#{id}" )
    ImgMsg selectImgByImgId(int id);

    @Delete("delete from ImgMsg where img_id=#{imgID}")
    int deleteImg(int imgID);

    @Update("Update ImgMsg set img_title=#{ImgTitle},img_desc=#{ImgDesc} where img_id=#{ImgId}")
    int updateImg(ImgMsg imgMsg);
}
