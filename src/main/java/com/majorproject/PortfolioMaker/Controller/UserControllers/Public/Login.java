package com.majorproject.PortfolioMaker.Controller.UserControllers.Public;


import com.majorproject.PortfolioMaker.ServiceImpl.UsersServiceImpl;
import com.majorproject.PortfolioMaker.models.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/public/api/v1/users")
@RequiredArgsConstructor
public class Login {
    private final UsersServiceImpl usersService;

    @PostMapping(value = "/login")
    public ResponseEntity<SuccessResponse> signUp(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "psd") String psd
    ) throws Exception {
        return ResponseEntity.ok().body(this.usersService.login(email, psd));
    }
}
