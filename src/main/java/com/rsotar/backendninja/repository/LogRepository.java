package com.rsotar.backendninja.repository;

import com.rsotar.backendninja.entity.Log;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

@Qualifier("logRepository")
public interface LogRepository extends JpaRepository<Log,Serializable>{
}
