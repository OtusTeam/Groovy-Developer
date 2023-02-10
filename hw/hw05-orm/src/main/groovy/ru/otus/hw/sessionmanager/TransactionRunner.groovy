package ru.otus.hw.sessionmanager;

interface TransactionRunner {
    <T> T doInTransaction(Closure<T> action)
}
