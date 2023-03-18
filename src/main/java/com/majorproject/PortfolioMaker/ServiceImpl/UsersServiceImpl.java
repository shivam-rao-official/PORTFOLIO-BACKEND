package com.majorproject.PortfolioMaker.ServiceImpl;

import com.majorproject.PortfolioMaker.Dto.UsersDto;
import com.majorproject.PortfolioMaker.Entity.Users;
import com.majorproject.PortfolioMaker.Exceptions.BadCredentials;
import com.majorproject.PortfolioMaker.Exceptions.UserAlreadyExists;
import com.majorproject.PortfolioMaker.Repository.UsersRepository;
import com.majorproject.PortfolioMaker.Services.UserServices;
import com.majorproject.PortfolioMaker.models.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UserServices {

    private final UsersRepository usersRepository;

    /***
     * @method createUser
     * @param usersDto
     * @desc this method will take the data from request body,
     * validates the data and creates a user in db.
     */
    @Override
    public SuccessResponse createUser(UsersDto usersDto) throws Exception {
        if (this.usersRepository.existsByEmail(usersDto.getEmail()))
            throw new UserAlreadyExists("User already exists with same email");

        try {
            var newUser = Users.builder()
                    .name(usersDto.getName())
                    .phnNo(usersDto.getPhnNo())
                    .email(usersDto.getEmail())
                    .psd(usersDto.getPsd())
                    .createdOn(new Date(System.currentTimeMillis()))
                    .lastModifiedOn(new Date(System.currentTimeMillis()))
                    .build();

            this.usersRepository.save(newUser);

            return SuccessResponse.builder()
                    .msg("User created successfully")
                    .httpStatus(HttpStatus.CREATED)
                    .httpCode(HttpStatus.CREATED.value())
                    .timeStamp(new Date(System.currentTimeMillis()))
                    .build();
        } catch (Exception ex) {
            throw new Exception();
        }
    }

    /**
     * @param email
     * @param psd
     * @return
     */
    @Override
    public SuccessResponse login(String email, String psd) throws Exception {
        if (email.isEmpty() || email.isBlank() || psd.isBlank() || psd.isEmpty())
            throw new BadCredentials("Invalid credentials");

        try {
            Users byEmail = this.usersRepository.findByEmail(email);
            if (byEmail == null || !Objects.equals(byEmail.getPsd(), psd))
                throw new BadCredentials("Invalid credentials");

            return SuccessResponse.builder()
                    .msg("Log in success")
                    .httpStatus(HttpStatus.OK)
                    .httpCode(HttpStatus.OK.value())
                    .timeStamp(new Date(System.currentTimeMillis()))
                    .build();
        }catch (BadCredentials ex) {
            throw new BadCredentials("Invalid credentials");
        }
    }

    /**
     * @param email
     * @param updatedRecord
     * @return
     */
    @Override
    public SuccessResponse updateUser(String email, UsersDto updatedRecord) {
        return null;
    }
}
