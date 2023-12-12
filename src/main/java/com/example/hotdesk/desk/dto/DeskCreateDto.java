package com.example.hotdesk.desk.dto;

import com.example.hotdesk.desk.entity.Accessories;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeskCreateDto
{
    @NotNull
    private Integer roomId;
    private List<Accessories> accessories;
}
