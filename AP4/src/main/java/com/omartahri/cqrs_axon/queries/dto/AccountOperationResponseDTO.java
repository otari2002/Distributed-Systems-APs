package com.omartahri.cqrs_axon.queries.dto;

import com.omartahri.cqrs_axon.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class AccountOperationResponseDTO {
    private Long id;
    private Date operationDate;
    private BigDecimal amount;
    private OperationType type;
}
