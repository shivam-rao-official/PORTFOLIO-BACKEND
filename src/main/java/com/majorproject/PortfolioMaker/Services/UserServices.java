package com.majorproject.PortfolioMaker.Services;

import com.majorproject.PortfolioMaker.Dto.UsersDto;
import com.majorproject.PortfolioMaker.models.SuccessResponse;

public interface UserServices {

    /***
     * @method createUser
     * @param usersDto
     * @desc this method will take the data from request body,
     * validates the data and creates a user in db.
     */
    public SuccessResponse createUser(UsersDto usersDto) throws Exception;

    public SuccessResponse login(String email, String psd) throws Exception;

    public SuccessResponse updateUser(String email, UsersDto updatedRecord);
}
