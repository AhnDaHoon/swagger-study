package swagger.study.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import swagger.study.response.Message;
import swagger.study.response.StatusEnum;
import swagger.study.user.RequestUserDto;
import swagger.study.user.ResponseUserDto;
import swagger.study.user.UserDto;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String, ResponseUserDto> responseUserDtoMap = new HashMap<>();

    private Map<String, UserDto> UserDtoMap = new HashMap<>();

    @PostConstruct
    public void init() {
        for (int i = 1; i <= 30; i++) {
            String id = "id"+i;
            String name = "이름"+i;
            ResponseUserDto responseUserDto = ResponseUserDto.builder()
                    .userName(name)
                    .build();
            responseUserDtoMap.put(name, responseUserDto);

            UserDto userDto = UserDto.builder()
                    .userName(name)
                    .password("asd" + i)
                    .build();
            UserDtoMap.put(id, userDto);
        }
    }

    public Message searchUser(String userName){
        Message message = null;
        if (responseUserDtoMap.containsKey(userName)) {
            message = Message.builder()
                    .data(responseUserDtoMap.get(userName))
                    .message(userName+" 회원을 조회했습니다.")
                    .statusEnum(StatusEnum.OK)
                    .build();
            return message;
        }
        message = Message.builder()
                .message(userName+" 회원이 존재하지 않습니다.")
                .statusEnum(StatusEnum.NOT_FOUND)
                .build();
        return message;
    }

    public Message createUser(RequestUserDto requestUserDto){
        String userName = requestUserDto.getUserName();
        String password = requestUserDto.getPassword();
        Message message = null;
        if (responseUserDtoMap.containsKey(userName)) {
            message = Message.builder()
                    .data(userName)
                    .message(userName+" 회원이 존재합니다.")
                    .statusEnum(StatusEnum.CONFLICT)
                    .build();
            return message;
        }

        UserDto userDto = UserDto.builder()
                .userName(userName)
                .password(password)
                .build();

        UserDtoMap.put(userName, userDto);

        ResponseUserDto responseUserDto = ResponseUserDto.builder()
                .userName(userName)
                .build();
        responseUserDtoMap.put(userName, responseUserDto);

        message = Message.builder()
                .data(userName)
                .message(userName+" 회원을 추가했습니다.")
                .statusEnum(StatusEnum.OK)
                .build();
        return message;
    }

    public Message deleteUser(String userName){
        Message message = null;

        if (responseUserDtoMap.containsKey(userName)) {
            responseUserDtoMap.remove(userName);
            message = Message.builder()
                    .data(true)
                    .message("회원이 삭제되었습니다.")
                    .statusEnum(StatusEnum.OK)
                    .build();
            return message;
        }
        message = Message.builder()
                .data(false)
                .message("회원이 존재하지 않습니다.")
                .statusEnum(StatusEnum.NOT_FOUND)
                .build();
        return message;
    }
}
