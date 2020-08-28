import com.college.dao.MessageDao;
import com.college.dao.Party_Affairs_Organization_MemberDao;
import com.college.dao.School_LeaderDao;
import com.college.dao.Student_Affairs_OfficeDao;
import com.college.domain.Message;
import com.college.domain.Party_Affairs_Organization_Member;
import com.college.domain.School_Leader;
import com.college.domain.Student_Affairs_Office;
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
        Party_Affairs_Organization_MemberDao party_affairs_organization_memberDao=ac.getBean(Party_Affairs_Organization_MemberDao.class);
//        HashMap<Object, Object> map = new HashMap<>();
//        map.put("leader_ID",1);
//        map.put("leader_name",leader_name);
//        map.put("leader_title",leader_title);
        List<Party_Affairs_Organization_Member> leader = party_affairs_organization_memberDao.getAll();
        for (Party_Affairs_Organization_Member s:leader
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
