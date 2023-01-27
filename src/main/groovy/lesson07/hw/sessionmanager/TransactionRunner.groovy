package lesson07.hw.sessionmanager;

interface TransactionRunner {
    <T> T doInTransaction(Closure<T> action)
}
