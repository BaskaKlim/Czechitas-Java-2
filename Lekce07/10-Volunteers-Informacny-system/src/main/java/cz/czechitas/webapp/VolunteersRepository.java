package cz.czechitas.webapp;

import java.util.*;
import java.util.concurrent.*;

public class VolunteersRepository {
    //using CopyOnWriteArrayList because it is able to handle multiple request in runtime
    private  List<Volunteer> volunteers = new CopyOnWriteArrayList<>(Arrays.asList(
            new Volunteer("Stela","Karlaj","s.karlaj@gmail.com","Študentka medicíny",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","žena","2020-04-20"),

            new Volunteer("Hoi","Yori","yori@gmail.com","Doktor",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","muž","2020-05-03"),
            new Volunteer("Zolda","Murani","s.karlaj@gmail.com","Zdravotná sestra",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","žena","2020-06-15"),
            new Volunteer("David","Coller","collerdavid@gmail.com","Študent medicíny",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","muž","2020-04-28"),
            new Volunteer("Kamila","Ignaci","s.karlaj@gmail.com","Zdravotná sestra",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","žena","2020-04-31"),

            new Volunteer("Jan","Lukacsi","lukasci.janci@gmail.com","Doktor",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","muž","2020-05-29"),
            new Volunteer("Tadeas","Tomat","pomodoro@gmail.com","Študent medicíny",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","muž","2020-07-06"),
            new Volunteer("Severin","Klimek","tatranec234@gmail.com","Doktor",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","muž","2020-04-08"),
            new Volunteer("Jana","Milek","trencan24@gmail.com","Študent medicíny",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","žena","2020-05-15"),
            new Volunteer("Zuzana","Meri","merizuz@gmail.com","Doktorka",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.","žena","2020-04-25")

    ));

    public List showVolunteers(){
        return volunteers;
    }

}
