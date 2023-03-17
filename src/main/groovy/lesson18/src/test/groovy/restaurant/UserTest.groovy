package restaurant

import org.grails.datastore.mapping.query.api.BuildableCriteria
import org.junit.Before
import org.junit.jupiter.api.Test

class UserTest {
    User user;

    @Before
    public void before() {
        User user = new User(username: 'Vasya',password:  '123')
        user.save()
    }

    @Test
    public void testVrud() {
        User.count()
        selected = User.roles.find {it.username == 'Vasya'}
    }

    @Test
    public void testCriteria() {
        def criteria = User.createCriteria()
        criteria.listDistinct {
            ilike('username', 'ya')
            roles {
                inList('authority', ['Admin', 'User'])
            }
        }
    }

    @Test
    public void testHql() {
        // SELECT user.username,  user.role.authority from User user
        User.findAll {"SELECT user.username,  user.role.authority from User user"}
        User.executeQuery("SELECT user.username from User user where username = :username and age = :age",
        [username: 'Vasya'], [age:10])
    }
}
