package jp.co.iccom.suzuki_yoshihiro.springdata_jpa_example.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the persons database table.
 *
 */
@Entity
@Table(name="persons")

@NamedQueries({
	@NamedQuery(name="PersonEntity.findAll", query="SELECT p FROM PersonEntity p"),
	@NamedQuery(name="PersonEntity.findById", query="SELECT p FROM PersonEntity p WHERE p.id = :id")
})

@Data
public class PersonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int age;

	private String name;

	private String sex;

	public PersonEntity() {
	}
}