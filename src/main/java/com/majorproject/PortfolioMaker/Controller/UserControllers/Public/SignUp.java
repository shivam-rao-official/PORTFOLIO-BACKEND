package com.majorproject.PortfolioMaker.Controller.UserControllers.Public;


import com.majorproject.PortfolioMaker.Dto.UsersDto;
import com.majorproject.PortfolioMaker.ServiceImpl.UsersServiceImpl;
import com.majorproject.PortfolioMaker.models.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/public/api/v1/users")
@RequiredArgsConstructor
public class SignUp {

    private final UsersServiceImpl usersService;

    @PostMapping(value = "/signUp")
    public ResponseEntity<SuccessResponse> signUp(
            @RequestBody UsersDto usersDto
            ) throws Exception {
        return ResponseEntity.ok().body(this.usersService.createUser(usersDto));
    }
}
