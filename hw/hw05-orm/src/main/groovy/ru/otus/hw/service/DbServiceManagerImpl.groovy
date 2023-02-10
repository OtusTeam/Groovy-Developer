package ru.otus.hw.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import ru.otus.hw.model.Manager
import ru.otus.hw.repository.DataTemplate
import ru.otus.hw.sessionmanager.TransactionRunner

class DbServiceManagerImpl implements DBServiceManager {
    private static final Logger log = LoggerFactory.getLogger(DbServiceManagerImpl.class)

    private final DataTemplate<Manager> managerDataTemplate
    private final TransactionRunner transactionRunner

    public DbServiceManagerImpl(TransactionRunner transactionRunner, DataTemplate<Manager> managerDataTemplate) {
        this.transactionRunner = transactionRunner
        this.managerDataTemplate = managerDataTemplate
    }

    @Override
    Manager saveManager(Manager manager) {
        transactionRunner.doInTransaction(connection -> {
            if (manager.getNo() == null) {
                def managerNo = managerDataTemplate.insert(connection, manager)
                def createdManager = new Manager(managerNo, manager.getLabel(), manager.getParam1())
                log.info("created manager: {}", createdManager)
                createdManager
            }
            managerDataTemplate.update(connection, manager)
            log.info("updated manager: {}", manager)
            manager;
        });
    }

    @Override
    Optional<Manager> getManager(long no) {
        transactionRunner.doInTransaction(connection -> {
            def managerOptional = managerDataTemplate.findById(connection, no)
            log.info("manager: {}", managerOptional)
            managerOptional
        });
    }

    @Override
    List<Manager> findAll() {
        transactionRunner.doInTransaction(connection -> {
            def managerList = managerDataTemplate.findAll(connection)
            log.info("managerList:{}", managerList)
            managerList;
        });
    }
}
