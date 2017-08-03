package com.linesum.example.guava;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.*;
import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-07-20 15:57
 */
@Log4j
public class ThreadCase {

    @Test
    public void testThreadWithGuava(){
        ListeningExecutorService service = null;
        try{
            service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(3));

            List<ListenableFuture<Boolean>> futureList = Lists.newArrayList();
            for (int i = 0; i <= 100; i++){
                final int tempI =i;
                ListenableFuture<Boolean> listenableFuture = service.submit(() -> {
                    if(tempI % 2 == 1){
                        log.info(Thread.currentThread().getName() + "------true");
                        return true;
                    }
                    log.info(Thread.currentThread().getName() + "------false");
                    return false;
                });
                futureList.add(listenableFuture);
            }

            ListenableFuture<List<Boolean>> listenableFuture = Futures.allAsList(futureList);

            Futures.addCallback(listenableFuture, new FutureCallback<List<Boolean>>() {
                @Override
                public void onSuccess(List<Boolean> aBoolean) {
                    log.info("success");
                }

                @Override
                public void onFailure(Throwable throwable) {
                    log.error("error");
                }
            });
        }catch (Exception e){
            log.error(e);
        }finally {
            service.shutdown();
        }

    }
}
