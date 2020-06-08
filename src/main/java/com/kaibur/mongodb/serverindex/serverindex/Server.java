package com.kaibur.mongodb.serverindex.serverindex;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection = "Server")
public class Server {

    @Transient
    public static final String SEQUENCE_NAME ="users_sequence";

    @Id
    @ApiModelProperty(notes = "The database generated server ID")
    private long id;


    public Server(@NonNull String serverName, String serverLanguage, String serverFramework, String description, String imageUrl) {
        this.serverName = serverName;
        this.serverLanguage = serverLanguage;
        this.serverFramework = serverFramework;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    @NonNull
    @Indexed(direction =  IndexDirection.ASCENDING, unique = true)
    @ApiModelProperty(notes = "serverName given to the database")
    private String serverName;

    @ApiModelProperty(notes = "Language used to create server")
    private String serverLanguage;

    @ApiModelProperty(notes = "Framework used to create server")
    private String serverFramework;

    @ApiModelProperty(notes = "Description for the server")
    private String description;

    @ApiModelProperty(notes = "ImageUrl of the server")
    private String imageUrl;

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

}