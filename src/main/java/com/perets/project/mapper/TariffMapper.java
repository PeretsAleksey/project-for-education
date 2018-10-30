package com.perets.project.mapper;

import com.perets.project.domain.Tariff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TariffMapper {

//    @Select("SELECT * FROM tariff WHERE id = #{id}")
    Tariff getTariffById(@Param("id") Integer id);
}
