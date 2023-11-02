package swagger.study.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class RequestUserDto {

    @Schema(description = "회원 이름", example = "user31")
    private String userName;

    @Schema(description = "회원 비밀번호", example = "asdjiwd31")
    private String password;
}
