# Junit Bank App

### Jpa LocalDateTime 자동으로 생성하는 법
 - @EnableJpaAuditing 메인 클래스에 적용
 - @EntityListeners(AuditingEntityListener.class) Entity 클래스 적용
```
   @CreatedDate // Insert
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate // Insert , Update
    @Column(nullable = false)
    private LocalDateTime updateAt;
```