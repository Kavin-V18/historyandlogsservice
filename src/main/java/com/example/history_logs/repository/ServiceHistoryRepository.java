package com.example.history_logs.repository;

import com.example.history_logs.entity.ServiceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceHistoryRepository extends JpaRepository<ServiceHistory,Integer> {
}
