package com.example.cqxt.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserRequest {
      @JsonProperty("id")
      private int id;
      @JsonProperty("username")
      private String usename;
      @JsonProperty("password")
      private String password;
      private boolean sex;
      private String phonenum;
      @JsonProperty("email")
      private String email;
      private String avatar;
      @JsonProperty("name")
      private String name;
}
