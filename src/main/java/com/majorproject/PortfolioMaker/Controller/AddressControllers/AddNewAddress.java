package com.majorproject.PortfolioMaker.Controller.AddressControllers;

import com.majorproject.PortfolioMaker.Dto.AddressDto;
import com.majorproject.PortfolioMaker.ServiceImpl.AddressServiceImpl;
import com.majorproject.PortfolioMaker.models.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/private/api/v1/address")
@RequiredArgsConstructor
public class AddNewAddress {

    private final AddressServiceImpl addressService;

    @PostMapping(value = "/add")
    public ResponseEntity<SuccessResponse> addAddress(
            @RequestParam(name = "email") String email,
            @RequestBody AddressDto addressDto
            ) throws MissingServletRequestParameterException, DuplicateKeyException {
        return ResponseEntity.ok().body(this.addressService.addNewAddress(email, addressDto));
    }
}
