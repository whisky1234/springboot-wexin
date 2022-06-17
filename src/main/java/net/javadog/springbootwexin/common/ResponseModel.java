/**
 * Copyright &copy; 2005-2020 <a href="http://www.jhmis.com/">jhmis</a> All rights reserved.
 */
package net.javadog.springbootwexin.common;

import java.io.Serializable;


public class ResponseModel<T> implements Serializable {

	private static final long   serialVersionUID = -2177650628109118809L;
	private static final String SUCCESS_CODE     = "000";
	private static final String SUCCESS_DESC     = "操作成功";
	private static final String FAIL_CODE        = "999";
	private static final String FAIL_DESC        = "操作失败";
	/**
	 * 返回结果码
	 */
	private              String code;
	/**
	 * 返回结果描述
	 */
	private              String desc;
	/**
	 * 返回数据
	 */
	private              T      content;
	/**
	 * 调用时间戳
	 */
	private              long   timestamp;

	public ResponseModel() {
		super();
	}

	public ResponseModel(T content) {
		super();
		this.content = content;
		this.timestamp = System.currentTimeMillis();
	}


	public ResponseModel(String code, String desc) {
		super();
		this.code = code;
		this.desc = desc;
		this.timestamp = System.currentTimeMillis();
	}

	public ResponseModel(String code, String desc, T content) {
		super();
		this.code = code;
		this.desc = desc;
		this.content = content;
		this.timestamp = System.currentTimeMillis();
	}

	public String getCode() {
		return code;
	}

	public ResponseModel setCode(String code) {
		this.code = code;
		return this;
	}

	public String getDesc() {
		return desc;
	}

	public ResponseModel setDesc(String desc) {
		this.desc = desc;
		return this;
	}

	public T getContent() {
		return content;
	}


	public void setContent(T content) {
		this.content = content;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public ResponseModel setTimestamp(long timestamp) {
		this.timestamp = timestamp;
		return this;
	}


	public static ResponseModel succ() {
		return succ(null);
	}

	//    public static ResponseModel succ(Object data) {
//        ResponseModel ret = new ResponseModel();
//        ret.setCode(SUCCESS_CODE);
//        ret.setDesc(SUCCESS_DESC);
//        ret.setTimestamp(System.currentTimeMillis());
//        ret.setContent(data);
//        return ret;
//    }
	public static <T> ResponseModel<T> succ(T data) {
		ResponseModel<T> ret = new ResponseModel<>();
		ret.setCode(SUCCESS_CODE);
		ret.setDesc(SUCCESS_DESC);
		ret.setTimestamp(System.currentTimeMillis());
		ret.setContent(data);
		return ret;
	}

	public static ResponseModel fail() {
		return fail(FAIL_CODE, FAIL_DESC);
	}

	public static ResponseModel fail(String message) {
		return fail(FAIL_CODE, message);
	}

	public static ResponseModel fail(String code, String message) {
		ResponseModel ret = new ResponseModel();
		ret.setCode(code);
		ret.setDesc(message);
		ret.setTimestamp(System.currentTimeMillis());
		return ret;
	}

}

