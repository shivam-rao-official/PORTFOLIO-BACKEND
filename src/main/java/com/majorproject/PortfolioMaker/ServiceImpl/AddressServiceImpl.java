package com.majorproject.PortfolioMaker.ServiceImpl;

import com.majorproject.PortfolioMaker.Dto.AddressDto;
import com.majorproject.PortfolioMaker.Entity.Address;
import com.majorproject.PortfolioMaker.Entity.Users;
import com.majorproject.PortfolioMaker.Exceptions.BadCredentials;
import com.majorproject.PortfolioMaker.Exceptions.InvalidArgumentException;
import com.majorproject.PortfolioMaker.Repository.AddressRepository;
import com.majorproject.PortfolioMaker.Repository.UsersRepository;
import com.majorproject.PortfolioMaker.Services.AddressService;
import com.majorproject.PortfolioMaker.models.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final UsersRepository usersRepository;
    private final AddressRepository addressRepository;

    /**
     * @param email
     * @param addressDto
     * @return
     */
    @Override
    public SuccessResponse addNewAddress(String email, AddressDto addressDto)
            throws MissingServletRequestParameterException,
            DuplicateKeyException {
        if (email.isEmpty())
            throw new MissingServletRequestParameterException("email", "String");
        try {
            Users byEmail = this.usersRepository.findByEmail(email);
            if (byEmail == null) throw new BadCredentials("Invalid credential");
            if (this.addressRepository.existsByUser_UserId(byEmail.getUserId()))
                throw new DuplicateKeyException("User already exists");
            var address = Address.builder()
                    .state(addressDto.getState())
                    .city(addressDto.getCity())
                    .country(addressDto.getCountry())
                    .user(byEmail)
                    .createdOn(new Date(System.currentTimeMillis()))
                    .lastModifiedOn(new Date(System.currentTimeMillis()))
                    .build();

            this.addressRepository.save(address);
            return SuccessResponse.builder()
                    .msg("Address added successfully")
                    .httpStatus(HttpStatus.CREATED)
                    .httpCode(HttpStatus.CREATED.value())
                    .timeStamp(new Date(System.currentTimeMillis()))
                    .build();
        } catch (InvalidArgumentException ex) {
            throw new InvalidArgumentException("Invalid arguments");
        }
    }

    /**
     * @param email
     * @param updatedAddress
     * @return
     */
    @Override
    public SuccessResponse updateExistingAddress(String email, AddressDto updatedAddress) {
        return null;
    }
}
