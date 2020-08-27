import com.college.dao.MessageDao;
import com.college.dao.School_LeaderDao;
import com.college.domain.Message;
import com.college.domain.School_Leader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

public class Test {

    private String leader_name;
    private String leader_title;
    @org.junit.Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        School_LeaderDao school_leaderDao=ac.getBean(School_LeaderDao.class);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("leader_ID",1);
        map.put("leader_name",leader_name);
        map.put("leader_title",leader_title);
        List<School_Leader> leader = school_leaderDao.getLeader(map);
        for (School_Leader s:leader
             ) {
            System.out.println(s);
        }


//        MessageDao messageDao = ac.getBean(MessageDao.class);
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        HashMap<Object, Object> map = new HashMap<>();
//        map.put("messageTitle","今日将有大批学生返校");
//        map.put("messageType","今日热讯");
//        map.put("author",null);
//        int i = messageDao.insertMessage(map);
//        System.out.println("======="+i+"=========");
//        List<Message> message = messageDao.getMessage(map);
//        map.put("formatDate",sdf.format( message.get(0).getCreateDate()));
//        map.put("messageId",message.get(0).getMessageId());
//        int j = messageDao.updateMessage(map);
//        System.out.println("======="+j+"=========");
//        System.out.println("====1==="+sdf.format( message.get(0).getCreateDate())+"=====1====");
//        System.out.println("====2==="+message.get(0).getCreateDate()+"=====2====");
    }
}
