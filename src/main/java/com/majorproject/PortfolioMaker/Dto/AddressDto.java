package com.majorproject.PortfolioMaker.Dto;

import com.majorproject.PortfolioMaker.Entity.Users;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String state;
    private String city;
    private String country;
    private Date createdOn;
    private Date lastModifiedOn;
    private Users user;
}
