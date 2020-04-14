package com.junjunlei;

import com.google.gson.JsonObject;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsDemoApplicationTests {

    @Autowired
    JestClient jestClient;

    @Test
    public void contextLoads() {
        System.out.println(jestClient);
    }


    @Test
    public void index() throws IOException {
        User user = new User("Ca", "11111");
        Index index = new Index.Builder(user).index("index").type("type").build();
        jestClient.execute(index);
    }

    @Test
    public void search() throws IOException {
        String queryJson = "{\n" +
                "  \"query\": {\n" +
                "    \"match_all\": {}\n" +
                "  }\n" +
                "}\n";
        Search search = new Search.Builder(queryJson).addIndex("index").build();
        SearchResult execute = jestClient.execute(search);
        JsonObject object = execute.getJsonObject();
        System.out.println(object.toString());

        List<SearchResult.Hit<User, Void>> hits = execute.getHits(User.class);
        hits.forEach((u)->{
           User user= u.source;
            System.out.println(user.toString());
        });

    }
}

class User {
    private String userName;
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
