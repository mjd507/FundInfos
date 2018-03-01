package com.mjd507.springbootsample.dao;

import com.mjd507.springbootsample.beans.FundInfoAll;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface QiemanFundDaoMapper {

    @Select("SELECT * FROM qieman")
//    @Results({
//            @Result(property = "fundDate",  column = "fundDate"),
//            @Result(property = "fundInfo", column = "fundInfo")
//    })
    ArrayList<FundInfoAll> getHistoryFundInfo();

    @Select("SELECT * FROM qieman WHERE fundDate=#{date}")
    FundInfoAll getDayFundInfo(String date);

    @Insert("INSERT INTO qieman VALUES(#{date}, #{infos})")
    boolean addFundInfo(@Param("date") String date, @Param("infos") String infos);

    @Update("UPDATE qieman SET fundInfo=#{infos} WHERE fundDate=#{date}")
    boolean updateFundInfo(@Param("date") String date, @Param("infos") String infos);

}
