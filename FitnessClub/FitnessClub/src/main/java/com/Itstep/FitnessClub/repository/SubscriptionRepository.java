package com.Itstep.FitnessClub.repository;

import com.Itstep.FitnessClub.entity.Subscription;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Хранит инвормацию об абонементах (связь с клиентом, остаток занятий)
 * Отдельно, потому, что когда абонемент истекает, клиент покупает новый.
 */
@Repository
public class SubscriptionRepository {
    List<Subscription> subscriptions;

    public SubscriptionRepository(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
