// GenreListDTO.java
package com.example.demo.dto;

public class GenreListDTO {
    private Integer id;      // 장르목록 테이블의 PK
    private String name;  // 장르 이름 (예: "SF", "액션")

    // 기본 생성자
    public GenreListDTO() {}

    // 모든 필드를 초기화하는 생성자
    public GenreListDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter 및 Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GenreListDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}