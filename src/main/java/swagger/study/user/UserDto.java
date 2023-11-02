package swagger.study.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class UserDto {

    @Schema(description = "회원 이름")
    private String userName;

    @Schema(description = "회원 비밀번호")
    private String password;

}
