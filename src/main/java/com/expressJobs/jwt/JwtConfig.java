package com.expressJobs.jwt;

public class JwtConfig {
    private String secret;
    private String header;
    private String prefix;

    public JwtConfig(String secret, String header, String prefix) {
        this.secret = secret;
        this.header = header;
        this.prefix = prefix;
    }

    public String getSecret() {
        return secret;
    }

    public String getHeader() {
        return header;
    }

    public String getPrefix() {
        return prefix;
    }
}
