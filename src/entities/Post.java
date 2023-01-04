package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

    //Private static vai garantir que não haja um cópia de cada objeto para cada aplicação. Ou seja, apenas uma cópia para aplicação inteira
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private String title;
    private String content;
    private Integer likes;;

    private List<Comment> comments = new ArrayList<>();
    // Para coleções não utilizamos Setter, mas sim métodos para adicionar ou remover. (Regras de negócios)

    public Post(){
    }

    public Post(Date moment, String title, String content, Integer likes) {
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComments(Comment comment){
        comments.add(comment);
    }

    public void removeComments(Comment comment){
        comments.remove(comment);
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append(title +"\n");
       sb.append(likes);
       sb.append("Likes - ");
       sb.append(sdf.format(moment) + "\n");
       sb.append(content+ "\n");
       sb.append("Comments").append("\n");
       for(Comment c: comments){
           // Adiciono todos os ocmentários no StringBuilder
           sb.append(c.getText()).append("\n");
       }
        return sb.toString();
    }
}



