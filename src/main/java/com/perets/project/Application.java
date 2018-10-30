package com.perets.project;

import com.perets.project.mapper.PaymentMapper;
import com.perets.project.mapper.SubscriberMapper;
import com.perets.project.mapper.TariffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private SubscriberMapper subscriberMapper;
    private PaymentMapper paymentMapper;
    private TariffMapper tariffMapper;

    @Autowired
    public Application(SubscriberMapper subscriberMapper, PaymentMapper paymentMapper, TariffMapper tariffMapper) {
        this.subscriberMapper = subscriberMapper;
        this.paymentMapper = paymentMapper;
        this.tariffMapper = tariffMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        subscriberMapper.getSubscriber("Валенитн").forEach(System.out::println);
        System.out.println("---------------------------");
/*        System.out.println(subscriberMapper.getSubscriberById(1));
        System.out.println(subscriberMapper.getSubscriberById(2));
        System.out.println(subscriberMapper.getSubscriberById(3));
        System.out.println("---------------------------");
        System.out.println(paymentMapper.getPaymentByIdSub(1));
        System.out.println(paymentMapper.getPaymentByIdSub(2));
        System.out.println(paymentMapper.getPaymentByIdSub(3));
        System.out.println("---------------------------");
        System.out.println(tariffMapper.getTariffById(1));
        System.out.println(tariffMapper.getTariffById(3));
        System.out.println(tariffMapper.getTariffById(2));*/
    }

}
