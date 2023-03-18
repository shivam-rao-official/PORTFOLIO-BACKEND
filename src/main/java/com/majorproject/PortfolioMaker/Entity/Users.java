package com.majorproject.PortfolioMaker.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Date;
import java.util.Objects;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(name = "USERS_MASTER")
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;
    private String name;
    private Integer phnNo;
    private String email;
    private String psd;
    private Date createdOn;
    private Date lastModifiedOn;

    @OneToOne(mappedBy = "user")
    private Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Users users = (Users) o;
        return userId != null && Objects.equals(userId, users.userId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
