package com.example.user.cities.domain.executor

import io.reactivex.Scheduler

interface PostExecutorThread {
    fun getScheduler(): Scheduler
}