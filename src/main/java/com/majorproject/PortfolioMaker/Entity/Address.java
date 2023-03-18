package com.majorproject.PortfolioMaker.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Table(name = "ADDRESS_MASTER")
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long addressId;
    private String state;
    private String city;
    private String country;
    private Date createdOn;
    private Date lastModifiedOn;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
