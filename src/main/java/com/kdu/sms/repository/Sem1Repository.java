package com.kdu.sms.repository;

import com.kdu.sms.entity.Sem1Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Sem1Repository extends JpaRepository<Sem1Entity, Long> {

}
