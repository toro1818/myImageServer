package com.example.imageServer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "UserName")
    private String UserName;

//    @Column(name = "Password")
//    private String password;
//
//    @Column(name = "REAL_NAME")
//    private Integer real_name;
//
//    @Column(name="SEX")
//    private String sex;

}
