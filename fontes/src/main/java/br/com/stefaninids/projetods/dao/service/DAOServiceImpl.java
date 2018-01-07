package br.com.stefaninids.projetods.dao.service;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EmbeddedId;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.stefaninids.projetods.tools.util.log.ProjetoDSLogger;

public class DAOServiceImpl<EntityType, PKType> implements DAOService<EntityType, PKType> { 
	
	protected Logger logger = ProjetoDSLogger.getDAO();
	
	private Class<EntityType> persistentClass;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public DAOServiceImpl() {
		persistentClass = (Class<EntityType>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<EntityType> getPersistentClass() {
		return persistentClass;
	}
	
	protected EntityManager getEntityManager(){
		return entityManager;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void salvar(EntityType entityType) throws DAOServiceException {
		if (entityType == null) {
			throw new IllegalArgumentException("entidade invalida " + getPersistentClass().getSimpleName());
		}

		try {
			PKType pkType = getValuePk(entityType);
			if (pkType != null) {
				entityType = entityManager.merge(entityType);
			} else {
				entityManager.persist(entityType);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DAOServiceException("persist error in " + getPersistentClass().getSimpleName() + ". " + e.getMessage(), e);
		}
	}

	public void remover(PKType pkType) throws DAOServiceException {
		entityManager.remove(pkType);
	}
	
	public void detach(EntityType entityType) throws DAOServiceException {
		try {
			entityManager.detach(entityType);
		} catch (Exception e) {
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
	
	@SuppressWarnings("unchecked")	
	private PKType getValuePk(EntityType entityType){
		Field field = getFieldPk(entityType.getClass());
		if (field != null){
			try {
				return (PKType)field.get(entityType);
			} catch (IllegalArgumentException e) {
			} catch (IllegalAccessException e) {
			}
		}
		return null;
	}
	
	private Field getFieldPk(Class<?> entityType){
		Field fieldID = null;
		Field[] fields = entityType.getDeclaredFields();
		if (fields != null){
			for (Field field : fields) {
				if (field.isAnnotationPresent(Id.class)
						|| field.isAnnotationPresent(IdClass.class)
						|| field.isAnnotationPresent(EmbeddedId.class)){
					if (!field.isAccessible()){
						field.setAccessible(true);
					}
					return field;
				}
			}
		}
		
		Class<?> superClass = entityType.getSuperclass();
		if (superClass != null 
				&& !(superClass.equals(Object.class))){
			fieldID = getFieldPk(superClass);
		}		
		return fieldID;
	}
	
}
