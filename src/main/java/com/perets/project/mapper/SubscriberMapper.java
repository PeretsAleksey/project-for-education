package com.perets.project.mapper;

import com.perets.project.domain.Subscriber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SubscriberMapper {

    //    @Select("SELECT * FROM subscriber WHERE id = #{id}")
//    @ResultMap("subscriberResultMapper")
    Subscriber getSubscriberById(@Param("id") Integer id);

    //    @Select("SELECT * FROM subscriber")
//    @Results(id = "subscriberResultMapper", value = {
//            @Result(property = "id", column = "id"),
//            @Result(property = "name", column = "name"),
//            @Result(property = "tariff", column = "ref_tariff", javaType = Tariff.class,
//                    one = @One(select = "com.perets.project.mapper.TariffMapper.getTariffById", fetchType = FetchType.EAGER)),
//            @Result(property = "payments", column = "ref_tariff", javaType = List.class,
//                    many = @Many(select = "com.perets.project.mapper.PaymentMapper.getPaymentByIdSub"))})
    List<Subscriber> getSubscriber(@Param("name") String name);
}
