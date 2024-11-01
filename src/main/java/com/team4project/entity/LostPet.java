package com.team4project.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity // 엔티티 클래스임을 선언
@Table(name = "lost_pets") // 매핑할 테이블 이름
public class LostPet {

    @jakarta.persistence.Id
    @Id // 기본 키 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성되는 키 설정
    private Long id;

    @Enumerated(EnumType.STRING) // Enum 타입의 문자열로 저장
    private PetType type; // 반려동물 종류 (예: 개, 고양이 등)

    @Column(name = "pet_name", nullable = false) // 컬럼 이름 설정
    private String petName; // 반려동물 이름

    @Column(name = "owner_name", nullable = false)
    private String ownerName; // 보호자 이름

    @Column(name = "lost_location", nullable = false)
    private String lostLocation; // 실종 위치

    @Column(name = "reported_at", nullable = false)
    private LocalDateTime reportedAt = LocalDateTime.now(); // 신고 시간

    // 기본 생성자 (JPA에서 필요로 함)
    protected LostPet() {}

    // 생성자 (필요시 사용)
    public LostPet(PetType type, String petName, String ownerName, String lostLocation) {
        this.type = type;
        this.petName = petName;
        this.ownerName = ownerName;
        this.lostLocation = lostLocation;
        this.reportedAt = LocalDateTime.now();
    }

    // Getters, Setters (생략 가능) - 데이터 접근을 위해 필요할 수 있음

    public Long getId() {
        return id;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setReportedAt(LocalDateTime reportedAt) {
        this.reportedAt = reportedAt;
    }
}
