package com.mjd507.springbootsample.dao;

import com.mjd507.springbootsample.beans.FundInfoAll;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface AniuFundDaoMapper {

    @Select("SELECT * FROM aniu")
//    @Results({
//            @Result(property = "fundDate",  column = "fundDate"),
//            @Result(property = "fundInfo", column = "fundInfo")
//    })
    ArrayList<FundInfoAll> getHistoryFundInfo();

    @Select("SELECT * FROM aniu WHERE fundDate=#{date}")
    FundInfoAll getDayFundInfo(String date);

    @Insert("INSERT INTO aniu VALUES(#{date}, #{infos})")
    boolean addFundInfo(@Param("date")String date, @Param("infos")String infos);

    @Update("UPDATE aniu SET fundInfo=#{infos} WHERE fundDate=#{date}")
    boolean updateFundInfo(@Param("date")String date, @Param("infos")String infos);

}
