package com.spring.koction.repository;

import com.spring.koction.entity.ItemqId;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.koction.entity.Itemq;
//키가 복합키라 복합키 클래스로 지정해주셔야되요
public interface ItemqRepository extends JpaRepository<Itemq, ItemqId>{

}
