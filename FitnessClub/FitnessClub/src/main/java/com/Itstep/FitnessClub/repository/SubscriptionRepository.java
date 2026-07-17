package com.Itstep.FitnessClub.repository;

import com.Itstep.FitnessClub.entity.Subscription;

import java.util.List;

public class SubscriptionRepository {
    List<Subscription> subscriptions;

    public SubscriptionRepository(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
