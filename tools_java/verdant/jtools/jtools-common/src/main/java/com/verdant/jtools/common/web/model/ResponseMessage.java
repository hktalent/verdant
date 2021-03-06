package com.verdant.jtools.common.web.model;


import com.verdant.jtools.common.spring.utils.ContextUtils;
import com.verdant.jtools.metadata.code.ResultCode;
import com.verdant.jtools.metadata.exception.ServiceException;
import com.verdant.jtools.metadata.model.Page;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: verdant
 * @Desc: Response报文
 */
public class ResponseMessage {
    private static final String CODE_PATTERN = "(\\w+(\\.*)\\w+)*";
    /**
     * 接口返回码
     */
    private String code = "";

    /**
     * 结果对应描述
     */
    private String message = "";

    /**
     * 返回结果
     */
    private Object body;

    /**
     * 构造函数 ， 默认消息为成功
     */
    public ResponseMessage() {
        this.code = ResultCode.SUCCESS;
        processCode();
    }

    /**
     * 构造函数
     */
    public ResponseMessage(Exception e) {
        if (e instanceof ServiceException) {
            this.code = ((ServiceException) e).getExceptionCode();
        } else {
            this.code = ResultCode.ERROR_INNER;
        }
        processCode();
    }

    /**
     * 构造函数 ， 默认消息为成功
     *
     * @param body 消息体
     */
    public ResponseMessage(Object body) {
        this.code = ResultCode.SUCCESS;
        this.body = body;
        processCode();
    }

    /**
     * 构造函数
     *
     * @param resultCode 异常类型
     */
    public ResponseMessage(String resultCode) {
        this.code = resultCode;
        processCode();
    }


    /**
     * 取得result
     *
     * @return 返回result。
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置result
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 取得message
     *
     * @return 返回message。
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置message
     *
     * @param message 要设置的message。
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 取得body
     *
     * @return 返回body。
     */
    public Object getBody() {
        return body;
    }

    /**
     * 设置body
     *
     * @param body 要设置的body。
     */
    public void setBody(Object body) {
        this.body = body;
    }

    public void setBody(Page<?> page) {
        this.body = page;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "ResponseMessage [code=" + code + ", message=" + message + ", body=" + body + "]";
    }

    private void processCode() {
        if (!StringUtils.isEmpty(this.code) && this.code.matches(CODE_PATTERN)) {
            String message[] = ContextUtils.getMessage(this.code).split("\\|");
            this.message = message[0];
            this.code = message[1];
        } else {
            this.message = this.code;
            this.code = "-1";
        }
    }

}
