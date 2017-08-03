package com.linesum.example.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-07-10 14:09
 */
public class MyHystrixCommand extends HystrixCommand<Response>{

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String url;

    public MyHystrixCommand(Setter setter, String url) {
        super(setter);
        this.url = url;
    }

    @Override
    protected Response run() throws Exception {
        logger.info("服务正在被调用，当前线程：{}", Thread.currentThread().getName());
        Request request = new Request.Builder().url(url).build();
        return new OkHttpClient().newCall(request).execute();
    }

    @Override
    public Response getFallback(){
        logger.error("服务调用失败，失败url：{}", url);
        return null;
    }
}
