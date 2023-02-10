package ru.otus.hw.service

import ru.otus.hw.model.Client


interface DBServiceClient {

    Client saveClient(Client client);

    Client getClient(long id);

    List<Client> findAll();
}
