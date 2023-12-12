package com.example.hotdesk.office.entity;

import com.example.hotdesk.common.auditing.Auditable;
import com.example.hotdesk.order.entity.Order;
import com.example.hotdesk.room.entity.Room;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Office extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "office")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Room> rooms;

    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
    private List<Order> orders;
}
