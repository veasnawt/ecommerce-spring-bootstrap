package com.example.camboelectro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.example.camboelectro.model.Product;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SpringBootBootstrapLiveTest {

  private static final String API_ROOT
    = "http://localhost:8081/api/products";

  private Product createRandomProduct() {
      Product product = new Product();
      product.setName("iPhone 14 Pro Max");
      product.setPrice(999);
      product.setRatings(5);
      product.setDescription("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
      return product;
  }

  private String createProductAsUri(Product product) {
      Response response = RestAssured.given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(product)
        .post(API_ROOT);
      return API_ROOT + "/" + response.jsonPath().get("id");
  }

  @Test
  public void whenGetAllProducts_thenOK() {
      Response response = RestAssured.get(API_ROOT);
  
      assertEquals(HttpStatus.OK.value(), response.getStatusCode());
  }

  @Test
  public void whenGetProductsByName_thenOK() {
      Product product = createRandomProduct();
      createProductAsUri(product);
      Response response = RestAssured.get(
        API_ROOT + "/name/" + product.getName());
      
      assertEquals(HttpStatus.OK.value(), response.getStatusCode());
      assertTrue(response.as(List.class)
        .size() > 0);
  }
  @Test
  public void whenGetCreatedProductById_thenOK() {
      Product product = createRandomProduct();
      String location = createProductAsUri(product);
      Response response = RestAssured.get(location);
      
      assertEquals(HttpStatus.OK.value(), response.getStatusCode());
      assertEquals(product.getName(), response.jsonPath()
        .get("name"));
  }

  @Test
  public void whenGetNotExistProductById_thenNotFound() {
      Response response = RestAssured.get(API_ROOT + "/" + 7);
      
      assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
  }

  @Test
  public void whenCreateNewPrduct_thenCreated() {
      Product product = createRandomProduct();
      Response response = RestAssured.given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(product)
        .post(API_ROOT);
      
      assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
  }

  @Test
  public void whenInvalidProduct_thenError() {
      Product product = createRandomProduct();
      product.setName(null);
      Response response = RestAssured.given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(product)
        .post(API_ROOT);
      
      assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
  }

  @Test
  public void whenUpdateCreatedProduct_thenUpdated() {
      Product product = createRandomProduct();
      String location = createProductAsUri(product);
      product.setId(Long.parseLong(location.split("api/products/")[1]));
      product.setName("newProduct");
      Response response = RestAssured.given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(product)
        .put(location);
      
      assertEquals(HttpStatus.OK.value(), response.getStatusCode());

      response = RestAssured.get(location);
      
      assertEquals(HttpStatus.OK.value(), response.getStatusCode());
      assertEquals("newProduct", response.jsonPath()
        .get("name"));
  }

  @Test
  public void whenDeleteCreatedProduct_thenOk() {
      Product product = createRandomProduct();
      String location = createProductAsUri(product);
      Response response = RestAssured.delete(location);
      
      assertEquals(HttpStatus.OK.value(), response.getStatusCode());

      response = RestAssured.get(location);
      assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
  }
}
