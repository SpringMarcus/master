package com.kibo.order.data.entity.entity;

import com.kibo.order.data.entity.entity.order.Order;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "attributes")
public class Attributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Attributes() {}
 }
