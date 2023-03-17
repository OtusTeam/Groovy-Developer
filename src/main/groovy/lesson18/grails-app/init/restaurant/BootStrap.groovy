package restaurant

import grails.util.Environment

class BootStrap {

    UserDataService userDataService

    def init = { servletContext ->

        if (Environment.current == Environment.DEVELOPMENT) {
            final String username = 'sherlock'
            final String password = 'elementary'
            User user = userDataService.save(username, password, true, false, false, false, )
        }
    }
    def destroy = {
    }
}
