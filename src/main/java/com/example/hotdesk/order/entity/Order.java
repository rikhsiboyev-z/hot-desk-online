package com.example.hotdesk.order.entity;

import com.example.hotdesk.desk.entity.Desk;
import com.example.hotdesk.office.entity.Office;
import com.example.hotdesk.room.entity.Room;
import com.example.hotdesk.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "desk_id")
    private Desk desk;
    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

}
