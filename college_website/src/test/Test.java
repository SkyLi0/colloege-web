import com.college.dao.MessageDao;
import com.college.domain.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;

public class Test {
    @org.junit.Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        MessageDao messageDao = ac.getBean(MessageDao.class);
//        HashMap map = new HashMap();
//        map.put("messageType","学院新闻");
        List<Message> allMessage = messageDao.getAllMessage();
        for (Message m:allMessage
        ) {
            System.out.println(m);
        }
//        map.put()
//        map.put("messageType","学院新闻");
//        int a=messageDao.insertMessage(map);
//        System.out.println(a);


//        map.put("messageId",1);
//        map.put("messageType", "学院新闻");
//        int a = messageDao.updateMessage(map);
//        System.out.println(map.get("messageType"));
//        System.out.println(a);
    }
}
