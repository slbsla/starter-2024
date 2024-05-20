package com.slb.demo.auth;

public class AuthDTO {
    public record LoginRequest(String username, String password) { }
    public record Response(String message, String token) {}
    /***
     *
     * equivalent in java 17
     *
     *  public static class LoginRequest {
     *         private String username;
     *         private String password;
     *
     *         public LoginRequest(String username, String password) {
     *             this.username = username;
     *             this.password = password;
     *         }
     *
     *         public String getUsername() {
     *             return username;
     *         }
     *
     *         public String getPassword() {
     *             return password;
     *         }
     *     }
     *
     *     public static class Response {
     *         private String message;
     *         private String token;
     *
     *         public Response(String message, String token) {
     *             this.message = message;
     *             this.token = token;
     *         }
     *
     *         public String getMessage() {
     *             return message;
     *         }
     *
     *         public String getToken() {
     *             return token;
     *         }
     *     }
     *
     *
     */

}