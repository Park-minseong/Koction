package com.spring.koction.dto;


import com.spring.koction.entity.Item;
import com.spring.koction.entity.User;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class OrderDto {
    private int orderNo;
    private int orderPrice;
    private int itemNo;
    private String userId;
}
