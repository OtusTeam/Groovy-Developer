package lesson08

def socket = new Socket("localhost", 8080)
socket.withStreams {input, output ->
    output << "I'm client"
}
