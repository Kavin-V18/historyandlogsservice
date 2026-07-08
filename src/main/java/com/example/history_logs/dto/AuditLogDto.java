package com.example.history_logs.dto;

import com.example.history_logs.Action;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditLogDto {
    @NotBlank
    private String tableName;
    private int recordId;

    private Action action;
    @NotBlank
    private String changedData;
    //foreign-key --user
    private Long performedBy;
    @NotBlank
    private String ipAddress;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private Long createdBy;
    @NotNull
    private LocalDateTime lastModifiedAt;
    @NotNull
    private Long lastModifiedBy;
}
