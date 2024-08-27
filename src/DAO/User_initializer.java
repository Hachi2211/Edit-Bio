package DAO;

import ADT.ArrayList;
import ADT.ListInterface;
import Entity.User;

public class User_initializer {
    public ListInterface<User> initializeUser() {
        ListInterface<User> userList = new ArrayList<>();

        userList.add(new User("U001","john_doe", "\"Tech enthusiast who loves experimenting with new recipes and sharing them with the community.", null));
//        userList.add(new User("U002","jane_smith", "Digital marketing specialist who loves crafting creative campaigns and exploring new cuisines."));
//        userList.add(new User("U003","mike_jones", "UX designer focused on creating intuitive and user-friendly interfaces. Avid traveler."));
//        userList.add(new User("U004","emily_clark", "Data scientist who enjoys solving complex problems with machine learning. Yoga enthusiast."));
//        userList.add(new User("U005","sarah_brown", "Content writer with a love for storytelling and a knack for SEO strategies. Coffee addict."));
//        userList.add(new User("U006","david_wilson", "Full-stack developer with expertise in JavaScript frameworks. Enjoys hiking on weekends."));
//        userList.add(new User("U007","linda_martin", "Graphic designer passionate about typography and branding. Amateur photographer."));
//        userList.add(new User("U008","chris_lee", "AI researcher focused on natural language processing. Music lover and guitar player."));
//        userList.add(new User("U009","rachel_green", "Project manager with experience in agile methodologies. Loves organizing community events."));
//        userList.add(new User("U010","matthew_steph", "Cybersecurity analyst dedicated to protecting online privacy. Runner and marathon enthusiast."));

        return userList;
    }
}
