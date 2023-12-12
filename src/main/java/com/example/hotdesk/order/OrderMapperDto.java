package com.example.hotdesk.order;

import com.example.hotdesk.common.service.GenericDtoMapper;
import com.example.hotdesk.order.dto.OrderCreateDto;
import com.example.hotdesk.order.dto.OrderResponseDto;
import com.example.hotdesk.order.dto.OrderUpdateDto;
import com.example.hotdesk.order.entity.Order;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMapperDto extends GenericDtoMapper<Order, OrderCreateDto, OrderUpdateDto, OrderResponseDto> {

    private final ModelMapper mapper;

    @Override
    public Order toEntity(OrderCreateDto orderCreateDto) {

        return mapper.map(orderCreateDto, Order.class);
    }

    @Override
    public OrderResponseDto toResponseDto(Order order) {

        OrderResponseDto orderResponseDto = mapper.map(order, OrderResponseDto.class);
        orderResponseDto.setOfficeId(order.getOffice().getId());
        orderResponseDto.setDeskId(order.getDesk().getId());
        orderResponseDto.setRoomId(order.getRoom().getId());
        orderResponseDto.setUserId(order.getUser().getId());

        return orderResponseDto;
    }

    @Override
    public void update(OrderUpdateDto orderUpdateDto, Order order) {
        mapper.map(orderUpdateDto, order);
    }
}
