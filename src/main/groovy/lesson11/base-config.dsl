name = "MyTest"
description = "Apache Tomcat"

http {
    port = 80
    secure = false
}
https {
    port = 443
    secure = true
}

mappings = [
        {
            url = "/"
            active = true
        },
        {
            url = "/login"
            active = false
        }]
