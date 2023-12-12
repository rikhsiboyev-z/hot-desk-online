package com.example.hotdesk.room.entity;

import com.example.hotdesk.common.auditing.Auditable;
import com.example.hotdesk.desk.entity.Desk;
import com.example.hotdesk.office.entity.Office;
import com.example.hotdesk.order.entity.Order;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "room")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Desk> desks;
    private String number;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @Column(nullable = false)
    private Integer floorNumber;
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Office office;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Order> orders;
}
