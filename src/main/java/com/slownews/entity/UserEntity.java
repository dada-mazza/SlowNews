package com.slownews.entity;

import com.slownews.controller.Role;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "UserEntity.getAll",
                query = "select users from UserEntity users"),
        @NamedQuery(name = "UserEntity.getUserByLogin",
                query = "select user from UserEntity user where user.login = :login"),
        @NamedQuery(name = "UserEntity.getUserByEmail",
                query = "select user from UserEntity user where user.email = :email")
})

public class UserEntity implements SlowNewsEntity {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "user_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "id")
    private Long Id;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "dateRegistration", nullable = false)
    private Date dateRegistration;

    @Column
    @ManyToMany
    private Set<ArchiveNewsEntity> archiveNewsEntities;

    public UserEntity() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public Set<ArchiveNewsEntity> getArchiveNewsEntities() {
        return archiveNewsEntities;
    }

    public void setArchiveNewsEntities(Set<ArchiveNewsEntity> archiveNewsEntities) {
        this.archiveNewsEntities = archiveNewsEntities;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "Id=" + Id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", dateRegistration=" + dateRegistration +
                ", archiveNewsEntities=" + archiveNewsEntities +
                '}' + "\n";
    }
}
