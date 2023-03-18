package com.majorproject.PortfolioMaker.Services;

import com.majorproject.PortfolioMaker.Dto.AddressDto;
import com.majorproject.PortfolioMaker.models.SuccessResponse;
import org.springframework.web.bind.MissingServletRequestParameterException;

public interface AddressService {

    SuccessResponse addNewAddress(String email, AddressDto addressDto) throws MissingServletRequestParameterException;

    SuccessResponse updateExistingAddress(String email, AddressDto updatedAddress);
}
