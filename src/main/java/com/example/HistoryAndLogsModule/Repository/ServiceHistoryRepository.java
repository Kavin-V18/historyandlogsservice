package com.example.HistoryAndLogsModule.Repository;

import com.example.HistoryAndLogsModule.Entity.ServiceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceHistoryRepository extends JpaRepository<ServiceHistory,Integer> {
}
