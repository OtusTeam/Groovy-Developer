def content = request.getContent().toString()

html.html {
    head {

    }
    body {
        p {
            content
        }
    }
}
