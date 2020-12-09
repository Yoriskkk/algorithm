package com.pattern.observe.p2pcase.rebuild;

public class RegNotificationObserver implements RegObserver {

    private NotificationService notificationService;

    @Override
    public void handRegSuccess(long userId) {
        notificationService.sendInboxMessage(userId,"Welcome...");
    }
}
