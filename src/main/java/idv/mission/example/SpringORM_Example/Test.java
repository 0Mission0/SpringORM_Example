package idv.mission.example.SpringORM_Example;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class Test {
    public static void main(String[] args) {
        addPerson();
    }

    public static void addPerson() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new ClassPathResource("applicationContext.xml"));
        IPersonDao personDao = (IPersonDao) factory.getBean("personDao");

        Person person = new Person();
        person.setName("測試");
        person.setEnglishName("Test");
        person.setAge(20);
        person.setSex("男");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1984, 1, 14); // month index by 0
        Date birthday = calendar.getTime();
        person.setBirthday(birthday);
        person.setDescription("AddPerson Test");

        personDao.addPerson(person);

        System.out.println("addPerson done.");
    }
}
