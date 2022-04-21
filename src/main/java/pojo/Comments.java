package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data // getter setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comments {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;
}
