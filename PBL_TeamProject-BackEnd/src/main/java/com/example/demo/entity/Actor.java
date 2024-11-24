package com.example.demo.entity;

import java.util.HashSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set; //1

@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키를 자동 증가시키는 전략
    private Integer id;

    @Column(nullable = false, length = 50) // NOT NULL 제약 조건 및 최대 길이 설정
    private String actorName;

    @OneToMany(mappedBy = "actor")
    private Set<Cast> casts = new HashSet<>(); //1

    // 기본 생성자
    public Actor() {}

    // 필드를 사용하는 생성자
    public Actor(String actorName) {
        this.actorName = actorName;
    }

    // Getter 및 Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public Set<Cast> getCasts() {
        return casts;
    } //1

    public void setCasts(Set<Cast> casts) {
        this.casts = casts;
    } //1
}

