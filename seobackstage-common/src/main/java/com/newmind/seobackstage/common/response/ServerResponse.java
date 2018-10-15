package com.newmind.seobackstage.common.response;

import com.newmind.seobackstage.common.lambda.IAction;
import com.newmind.seobackstage.common.mapper.CGlibMapper;

import java.lang.reflect.Method;

/**
 * @Description 响应结果工具
 * create by zhoukc
 */
public class ServerResponse {

    private ServerResponse() {
    }

    public static <TResult extends IResult> TResult ok(Class<TResult> clazz) {
        TResult result = ToResult(null, ResultStates.SUCCEEDED.getIndex(), null, clazz, null);
        return result;
    }

    public static <TResult extends IResult> TResult ok(Object source, Class<TResult> clazz) {
        TResult result = ToResult(source, ResultStates.SUCCEEDED.getIndex(), null, clazz, null);
        return result;
    }

    public static <TResult extends IResult> TResult ok(Object source, Class<TResult> clazz, IAction<Object> action) {
        TResult result = ToResult(source, ResultStates.SUCCEEDED.getIndex(), null, clazz, action);
        return result;
    }

    public static <TResult extends IResult> TResult error(int failureReason, Class<TResult> clazz) {
        TResult result = ToResult(null, ResultStates.FAILED.getIndex(), Integer.valueOf(failureReason), clazz, null);
        return result;
    }

    public static <TResult extends IResult> TResult error(int failureReason, Object source, Class<TResult> clazz) {
        TResult result = ToResult(source, ResultStates.FAILED.getIndex(), Integer.valueOf(failureReason), clazz, null);
        return result;
    }

    private static <TResult extends IResult> TResult ToResult(Object source, int state, Integer failureReason, Class<TResult> clazz, IAction<Object> action) {
        Object content = null;
        TResult result;
        try {
            result = clazz.newInstance();
        } catch (Exception ex) {
            return null;
        }
        result.setResultStates(state);
        if ((failureReason != null) && (result instanceof IFailureReason))
            ((IFailureReason) result).setFailureReason(failureReason);

        if ((source == null) || (!(result instanceof IContent)))
            return result;

        IContent contentResult = (IContent) result;

        Method contentClazz = null;
        try {
            contentClazz = clazz.getMethod("getContent", new Class[0]);
        } catch (Exception ex) {
            return result;
        }

        if (contentClazz.getReturnType().isInstance(source)) {
            content = source;
        } else {
            content = CGlibMapper.mapper(source, contentClazz.getReturnType());
        }
        if (action != null)
            action.run(content);
        contentResult.setContent(content);
        return result;
    }

}
