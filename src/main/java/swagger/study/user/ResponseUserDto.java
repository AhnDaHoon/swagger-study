package swagger.study.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class ResponseUserDto {

    @Schema(description = "회원 이름")
    private String userName;

}
