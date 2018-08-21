package com.example.amirreza.dbsample.utilities;

import com.example.amirreza.dbsample.AppDatabase;
import com.example.amirreza.dbsample.entity.Comment;
import com.example.amirreza.dbsample.entity.Post;
import com.example.amirreza.dbsample.entity.User;

public class DataGenerator {


    private static DataGenerator instance;
    private static AppDatabase dataBase;


    public static DataGenerator with(AppDatabase appDataBase) {

        if (dataBase == null)
            dataBase = appDataBase;

        if (instance == null)
            instance = new DataGenerator();

        return instance;
    }


    public void generateAppDetails() {
        if (dataBase == null)
            return;

        User[] users = new User[4];
        users[0] = userInstance(1, "abbas", "fahimi" , "linkeAbbas", 123);
        users[1] = userInstance(2, "ahmad", "farhadi" , "linkeAhamd", 124);
        users[2] = userInstance(3, "Vahid", "Bashiri", "linkeVahid", 125);
        users[3] = userInstance(4, "Jalal", "Khaledi", "linkeJalal", 126);
        dataBase.DBDao().insertUsers(users);

        Post[] posts = new Post[3];
        posts[0] = postInstance(1, "sombol1", "salam1", "linkeSombol1",1);
        posts[1] = postInstance(2, "sombol2", "salam2", "linkeSombol2",1);
        posts[2] = postInstance(3, "sombol3", "salam3", "linkeSombol3",3);
        dataBase.DBDao().insertPosts(posts);

        Comment[] comments = new Comment[4];
        comments[0] = commentInstance(1, "shambalile", 1, 2);
        comments[1] = commentInstance(2, "zobale", 3, 3);
        comments[2] = commentInstance(3, "sonboletin", 4, 1);
        comments[3] = commentInstance(4, "ostoghodus", 4, 4);
        dataBase.DBDao().insertComments(comments);

    }

    private Comment commentInstance(int id, String commentBody, int userId, int postId) {
        Comment comment =new Comment();
        comment.setId(id);
        comment.setCommentBody(commentBody);
        comment.setUserId(userId);
        comment.setPostId(postId);
        return comment;
    }

    private User userInstance(int id, String firstName, String lastName, String avatarLink, int nationalCode) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAvatarLink(avatarLink);
        user.setNationalCode(nationalCode);
        return user;
    }

    private Post postInstance(int id, String title, String description, String imageLink, int userId) {
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setDescription(description);
        post.setImageLink(imageLink);
        post.setUserId(userId);
        return post;
    }
/*

    private Address addressInstance(String street, String state, String city, int postCode) {
        Address address = new Address();

        address.street = street;
        address.state = state;
        address.city = city;
        address.postCode = postCode;

        return address;
    }


    private Person personInstance(int id, String firstName, String lastName) {
        Person person = new Person();

        person.id = id;
        person.firstName = firstName;
        person.lastName = lastName;

        Address address = addressInstance("Some street name", "Some state", "Some city", 19421);
        dataBase.addressDao().insert(address);

        person.address = address;

        return person;
    }


    public void generateCats() {

        if (dataBase == null)
            return;

        Cat[] cats = new Cat[5];
        cats[0] = catInstance("Tony", 3, 1);
        cats[1] = catInstance("Tiger", 1, 1);
        cats[2] = catInstance("Misty", 2, 2);
        cats[3] = catInstance("Oscar", 5, 3);
        cats[4] = catInstance("Puss", 4, 4);

        dataBase.catDao().insert(cats);
    }


    private Cat catInstance(String name, int age, int owner) {
        Cat cat = new Cat();

        cat.name = name;
        cat.age = age;
        cat.hoomanId = owner;

        return cat;
    }*/
}
