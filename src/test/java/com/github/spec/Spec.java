package com.github.spec;

import com.github.config.CredentialsConfig;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.with;

public class Spec {

    public static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    public static String accept = "application/vnd.github+json";
    public static Header header = new Header("Authorization", "Bearer " + config.getApiToken());

    public static RequestSpecification reqSpec = with()
            .accept(accept)
            .header(header)
            .baseUri("https://api.github.com");

    public static ResponseSpecification resSpec = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();
}
