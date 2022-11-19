package com.bbs.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Data
public class ResponseVO {
    /**
     * 调用是否成功
     */
    private Boolean success;

    /**
     * 返回的提示信息
     */
    private String message;

    /**
     * 内容
     */
    private Object content;

    public static ResponseVO buildSuccess() {
        ResponseVO response = new ResponseVO();
        response.setSuccess(true);
        return response;
    }

    public static ResponseVO buildSuccess(Object content) {
        ResponseVO response = new ResponseVO();
        response.setContent(content);
        response.setSuccess(true);
        return response;
    }

    public static ResponseVO buildFailure(String message) {
        ResponseVO response = new ResponseVO();
        response.setSuccess(false);
        response.setMessage(message);
        System.out.println(message);
        return response;
    }
}
