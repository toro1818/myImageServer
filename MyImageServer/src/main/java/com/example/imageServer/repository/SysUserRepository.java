package com.example.imageServer.repository;

import com.example.imageServer.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser,Integer> {
}
