package idv.mission.example.SpringORM_Example;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class PersonDaoImpl extends HibernateDaoSupport implements IPersonDao {
    public void addPerson(Person person) {
        this.getHibernateTemplate().persist(person);
    }

    public List<Person> listPersons() {
        List<Person> people = (List<Person>) this.getHibernateTemplate().find("SELECT * FROM person");
        return people;
    }

}
