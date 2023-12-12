package com.example.hotdesk.order;

import com.example.hotdesk.order.dto.OrderCreateDto;
import com.example.hotdesk.order.dto.OrderResponseDto;
import com.example.hotdesk.order.dto.OrderUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class OrderController {


    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOffice(@RequestBody @Valid OrderCreateDto createDTo) {
        OrderResponseDto orderResponseDto = orderService.create(createDTo);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponseDto);
    }

    @GetMapping
    public ResponseEntity<Page<OrderResponseDto>> getOffices(Pageable pageable, @RequestParam(required = false) String predicate) {
        Page<OrderResponseDto> all = orderService.getAll(pageable, predicate);
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> get(@PathVariable("id") Integer id) {
        OrderResponseDto responseDto = orderService.getById(id);
        return ResponseEntity.ok(responseDto);
    }

    @PreAuthorize("hasAnyAuthority('UPDATE')")
    @PutMapping("/{id}")
    public ResponseEntity<OrderResponseDto> update(@PathVariable("id") Integer id, @RequestBody @Valid OrderUpdateDto updateDto) {
        OrderResponseDto responseDto = orderService.update(id, updateDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('DELETE')")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        orderService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
