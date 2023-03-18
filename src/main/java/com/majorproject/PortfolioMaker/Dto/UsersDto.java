package com.majorproject.PortfolioMaker.Dto;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsersDto {
    private String name;
    private Integer phnNo;
    private String email;
    private String psd;
}
