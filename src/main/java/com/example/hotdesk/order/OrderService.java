package com.example.hotdesk.order;

import com.example.hotdesk.common.service.GenericCrudService;
import com.example.hotdesk.desk.DeskRepository;
import com.example.hotdesk.desk.entity.Desk;
import com.example.hotdesk.office.OfficeRepository;
import com.example.hotdesk.office.entity.Office;
import com.example.hotdesk.order.dto.OrderCreateDto;
import com.example.hotdesk.order.dto.OrderPatchDto;
import com.example.hotdesk.order.dto.OrderResponseDto;
import com.example.hotdesk.order.dto.OrderUpdateDto;
import com.example.hotdesk.order.entity.Order;
import com.example.hotdesk.room.RoomRepository;
import com.example.hotdesk.room.entity.Room;
import com.example.hotdesk.user.UserRepository;
import com.example.hotdesk.user.entity.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Getter
public class OrderService extends GenericCrudService<Order, Integer, OrderCreateDto, OrderUpdateDto,
        OrderPatchDto, OrderResponseDto> {

    private final OrderRepository repository;
    private final OrderMapperDto mapper;
    private final Class<Order> EntityClass = Order.class;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final OfficeRepository officeRepository;
    private final DeskRepository deskRepository;


    @Override
    protected Order save(OrderCreateDto orderCreateDto) {

        User user = userRepository.findById(orderCreateDto.getUserId()).orElseThrow(EntityNotFoundException::new);

        Room room = roomRepository.findById(orderCreateDto.getRoomId()).orElseThrow(EntityNotFoundException::new);

        Desk desk = deskRepository.findById(orderCreateDto.getDeskId()).orElseThrow(EntityNotFoundException::new);

        Office office = officeRepository.findById(orderCreateDto.getOfficeId()).orElseThrow(EntityNotFoundException::new);

        Order order = mapper.toEntity(orderCreateDto);
        order.setUser(user);
        order.setRoom(room);
        order.setDesk(desk);
        order.setOffice(office);

        return repository.save(order);
    }

    @Override
    protected Order updateEntity(OrderUpdateDto orderUpdateDto, Order order) {
        mapper.update(orderUpdateDto, order);
        return repository.save(order);

    }
}
