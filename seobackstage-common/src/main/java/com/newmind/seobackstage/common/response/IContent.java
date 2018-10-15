package com.newmind.seobackstage.common.response;

public interface IContent<TContent> {

    void setContent(TContent content);

    TContent getContent();
}
