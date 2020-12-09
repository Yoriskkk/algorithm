package com.pattern.observe.p2pcase.rebuild;

import com.pattern.observe.p2pcase.PromotionService;

public class RegPromotionObserver implements RegObserver {
    private PromotionService promotionService;

    @Override
    public void handRegSuccess(long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
