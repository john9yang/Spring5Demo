package entity;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;

public class ResultViewModel {

    private int code;
    private String message;
    private ResultModel data;

    public static ResultViewModel EMPTY_RESULT = new ResultViewModel();

    public ResultViewModel() {
    }

    public ResultViewModel(int code, String message, ResultModel data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultModel getData() {
        return data;
    }

    public void setData(ResultModel data) {
        this.data = data;
    }
}
