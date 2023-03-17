package restaurant

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index") {
            action: [POST: 'create']
        }
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
