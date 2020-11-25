package com.example.redbag;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 数据库表中字段一一对应的实体类
 */
@Entity
@Data
@NoArgsConstructor
//指定该类是实体类
public class LuckyMoney {

    @Id
    //指定为主键
    @GeneratedValue
    //自增长
    private Integer id;
    private BigDecimal money;//红包金额
    private String producer; //发红包的人
    private String consumer; //收红包的人

    public LuckyMoney(Integer id, BigDecimal money, String producer, String consumer) {
        this.id = id;
        this.money = money;
        this.producer = producer;
        this.consumer = consumer;
    }


//    public LuckyMoney() {
//
//    }
}
