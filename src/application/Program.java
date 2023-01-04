package application;

import entities.Comment;
import entities.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Comment comment1 = new Comment("Have a nice trip!");
        Comment comment2 = new Comment("Wow that's awesome!");

        Post post1 = new Post(sdf.parse("21/06/2018 13:05:44"),
                "Traveling to New Zealand",
                "I'm going to visit this wonderful country!",
                12);

        // Outra maneira de instaciar um objeto dentro do método --> post1.addComments(new Comment("Have a nice trip!"));

        post1.addComments(comment1);
        post1.addComments(comment2);

        System.out.println(post1);

        Comment comment3 = new Comment("Good Night");
        Comment comment4 = new Comment("May the Force be with you");

        Post post2 = new Post(sdf.parse("28/07/2018 23:14:39"),
                "Good night guys",
                "See you tomorrow",
                3);

        post2.addComments(new Comment("Good Night"));
        post2.addComments(new Comment("May the Force be with you"));

        System.out.println(post2);
    }
}
