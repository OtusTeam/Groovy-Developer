package lesson07.hw.service

import lesson07.hw.model.Client;


interface DBServiceClient {

    Client saveClient(Client client);

    Optional<Client> getClient(long id);

    List<Client> findAll();
}
