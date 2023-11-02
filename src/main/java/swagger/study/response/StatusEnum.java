package swagger.study.response;

import lombok.Getter;

@Getter
public enum StatusEnum {
    OK(200, "OK"),
    NO_CONTENT(204, "NO CONTENT"),
    BAD_REQUEST(400, "BAD_REQUEST"),
    NOT_FOUND(404, "NOT_FOUND"),
    CONFLICT(409, "CONFLICT"),
    INTERNAL_SERER_ERROR(500, "INTERNAL_SERVER_ERROR");

    int statusCode;
    String code;

    StatusEnum(int statusCode, String code) {
        this.statusCode = statusCode;
        this.code = code;
    }
}
