package org.casa.probando.models;

import javax.persistence.*;

@Entity
@Table(name="citizen")
public class citizen {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private int id;

    @Column(name = "email")
    private String email;

    public citizen() {
        super();
    }

    public citizen(String email) {
        this.email=email;
    }

    public citizen(int id, String email) {
        this.id=id;
        this.email=email;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
    
}
