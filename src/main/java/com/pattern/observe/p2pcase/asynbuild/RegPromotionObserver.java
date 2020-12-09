package com.pattern.observe.p2pcase.asynbuild;

import com.pattern.observe.p2pcase.PromotionService;
import com.pattern.observe.p2pcase.rebuild.RegObserver;

public class RegPromotionObserver implements RegObserver {

    private PromotionService promotionService;

    @Override
    public void handRegSuccess(long userId) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                promotionService.issueNewUserExperienceCash(userId);
            }
        });
        thread.start();
    }
}
