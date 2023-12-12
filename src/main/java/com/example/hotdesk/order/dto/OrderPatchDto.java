package com.example.hotdesk.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderPatchDto {
    private Integer userId;
    private Integer roomId;
    private Integer deskId;
    private Integer officeId;
}

