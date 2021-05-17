//package ru.akkulov;
//
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import ru.akkulov.model.Team;
//import ru.akkulov.service.TeamService;
//
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
//
//        TeamService service = context.getBean("teamServiceBean", TeamService.class);
//        List<Team> list = service.getAll();
//        for (Team e : list) {
//            System.out.println(e);
//        }
//    }
//}
