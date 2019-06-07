package com.padawans.hackaton.apigateway.dao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class EventDAO {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String description;

    @Column
    private Long ammount;

    @ManyToMany
    @JoinTable(name = "event_like",
    joinColumns = @JoinColumn(name = "user_id"), 
    inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<UserDAO> users;

    public EventDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

}
