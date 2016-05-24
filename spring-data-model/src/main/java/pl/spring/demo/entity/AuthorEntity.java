package pl.spring.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "AUTHOR")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    
    @Version
    @Column(name = "optlock")
    private Long version;

    //for hibernate
    protected AuthorEntity() {

    }

    public AuthorEntity(Long id, String firstName, String lastName, Long version) {
        this(firstName, lastName);
        this.id = id;
        this.version = version;
    }

    public AuthorEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
    
}
