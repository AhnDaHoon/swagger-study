package swagger.study.response;

import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Message {
    private StatusEnum statusEnum;
    private String message;
    private String message2;
    private Object data;
}
