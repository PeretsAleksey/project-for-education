package com.perets.project.mapper;

import com.perets.project.domain.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentMapper {

//    @Select("SELECT * FROM payments WHERE id = #{id}")
    List<Payment> getPaymentByIdSub(@Param("id") Integer id);
}
