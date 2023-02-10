//package lesson08
//
//import java.net.http.HttpClient
//import java.net.http.HttpRequest
//import java.net.http.HttpResponse
//
//URLConnection getRequeest = new URL('https://yandex.ru').openConnection()
//
//println (new URL('https://yandex.ru').getText())
//println(getRequeest.getInputStream().getText())
//
//URLConnection postRequeest = new URL('https://yandex.ru').openConnection()
//postRequeest.setRequestMethod('POST')
//postRequeest.getOutputStream().write("message".getBytes('UTF-8'))
//postRequeest.setRequestProperty('Content-Type', 'text/plain')
//println(postRequeest.getInputStream().getText())
//
//
//
//def client = HttpClient.newBuilder().build()
//postRequeest = HttpRequest.newBuilder()
//.header('Content-Type', 'text/plain')
//.method('POST', HttpRequest.BodyPublishers.noBody())
//        .build()
//HttpResponse<Object> result = client.send(postRequeest)
