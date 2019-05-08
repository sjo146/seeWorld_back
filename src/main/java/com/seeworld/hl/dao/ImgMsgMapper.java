package com.seeworld.hl.dao;

import com.seeworld.hl.domain.ImgMsg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
@Mapper
public interface ImgMsgMapper {
@Select("select* from ImgMsg")
    ArrayList<ImgMsg> findAllImgMsg();
}
