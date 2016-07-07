package jp.co.iccom.suzuki_yoshihiro.springdata_jpa_example.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import jp.co.iccom.suzuki_yoshihiro.springdata_jpa_example.entity.PersonEntity;
import jp.co.iccom.suzuki_yoshihiro.springdata_jpa_example.form.PersonForm;
import jp.co.iccom.suzuki_yoshihiro.springdata_jpa_example.utils.EntityManagerUtil;

@Service
public class PersonService {
	@SuppressWarnings("unchecked")
	public List<PersonEntity> getPersonList() {
		EntityManager em = new EntityManagerUtil().getEntityManager();
		List<PersonEntity> personList = null;
		try {
			em.getTransaction().begin();
			personList = em.createNamedQuery("PersonEntity.findAll").getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			em.clear();
		}
		return personList;
	}

	public PersonEntity getPerson(int id) {
		EntityManager em = new EntityManagerUtil().getEntityManager();
		PersonEntity person = null;
		try {
			em.getTransaction().begin();
			person = (PersonEntity) em.createNamedQuery("PersonEntity.findById").setParameter("id", id)
					.getSingleResult();
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			em.clear();
		}
		return person;
	}

	public boolean updatePersonInfo(PersonForm person) {
		EntityManager em = new EntityManagerUtil().getEntityManager();
		boolean result = false;
		PersonEntity newPerson = null;
		try {
			em.getTransaction().begin();
			newPerson = (PersonEntity) em.createNamedQuery("PersonEntity.findById")
					.setParameter("id", person.getId())
					.getSingleResult();
			newPerson.setName(person.getName());
			newPerson.setAge(person.getAge());
			newPerson.setSex(person.getSex());
			em.getTransaction().commit();

			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			em.clear();
		}
		System.out.println(result);
		return result;
	}

	public boolean deletePerson(int id){
		EntityManager em = new EntityManagerUtil().getEntityManager();
		PersonEntity deletePerson = null;
		boolean result = false;
		try{
			em.getTransaction().begin();
			deletePerson = (PersonEntity) em.createNamedQuery("PersonEntity.findById")
					.setParameter("id", id)
					.getSingleResult();
			em.remove(deletePerson);
			em.getTransaction().commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			em.clear();
		}
		System.out.println(result);
		return result;
	}

	public boolean createPerson(PersonForm person){
		EntityManager em = new EntityManagerUtil().getEntityManager();
		PersonEntity createPerson = null;
		boolean result = false;
		try{
			em.getTransaction().begin();
			createPerson = new PersonEntity();
			createPerson.setName(person.getName());
			createPerson.setAge(person.getAge());
			createPerson.setSex(person.getSex());

			em.persist(createPerson);

			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			em.clear();
		}
		System.out.println(result);
		return result;
	}
}
