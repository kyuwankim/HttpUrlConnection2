package com.kyuwankim.android.httpurlconnection;

/**
 * Created by kimkyuwan on 2017. 6. 12..
 */

public interface TaskInterface {
    public String getUrl();
    public void postExecute(String result);
}