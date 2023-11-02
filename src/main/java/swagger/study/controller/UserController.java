package swagger.study.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swagger.study.response.Message;
import swagger.study.service.UserService;
import swagger.study.user.RequestUserDto;

@Tag(name = "01.User", description = "사용자 기능")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원 조회", description = "회원 이름으로 회원을 조회 합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Message.class))),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
    })
    @GetMapping(value = "/{userName}", headers = { "Content-type=application/json" })
    public ResponseEntity<?> searchUser(@Parameter(description = "회원 이름", required = true, example = "이름1") @PathVariable String userName){
        Message message = userService.searchUser(userName);
        return new ResponseEntity<>(message, null, message.getStatusEnum().getStatusCode());
    }

    @Operation(summary = "회원 추가", description = "회원 이름, PWD을 받아 회원을 생성합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Message.class))),
            @ApiResponse(responseCode = "409", description = "CONFLICT"),
    })
    @PostMapping(value = "", headers = { "Content-type=application/json" })
    public ResponseEntity<?> createUser(@RequestBody RequestUserDto requestUserDto){
        Message message = userService.createUser(requestUserDto);
        return new ResponseEntity<>(message, null, message.getStatusEnum().getStatusCode());
    }

    @Operation(summary = "회원 삭제", description = "회원 이름으로 회원을 삭제 합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Message.class))),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
    })
    @DeleteMapping(value = "/{userName}", headers = { "Content-type=application/json" })
    public ResponseEntity<?> deleteUser(@Parameter(description = "회원 이름", required = true, example = "이름1") @PathVariable String userName){
        Message message = userService.deleteUser(userName);
        return new ResponseEntity<>(message, null, message.getStatusEnum().getStatusCode());
    }

}
