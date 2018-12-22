package springprojectdb.demo.service;

import java.util.List;

public interface ScrapService  extends Runnable{
    @Override
    default void run() {

    }

    //    void scrap(List<String> keylist) throws InterruptedException;

}
