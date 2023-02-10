package lesson08

def socketServer = new ServerSocket(8080)

while(true) {
    socketServer.accept {it ->
        def result = "hello"
        it.withStreams {input, output ->
            output << result
        }
    }
}
