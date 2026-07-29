package com.enterprise.gateway.exchange;

import java.util.Map;

public interface Exchange {

    Message getIn();

    Message getOut();

    void setOut(Message message);

    Object getProperty(String key);

    void setProperty(String key, Object value);

    Map<String, Object> getProperties();

    Exception getException();

    void setException(Exception exception);

    boolean isRouteStopped();

    void stop();

}