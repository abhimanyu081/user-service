package dev.abhi.userservice.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.abhi.userservice.model.City;
import dev.abhi.userservice.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);
	
	@Autowired
	private EntityManager entityManager;

	@Autowired
	private CityRepository cityRepo;
	
	
	//@PostConstruct
	public void initCitySearchIndex() {
		LOGGER.info("Initializing City Search Index .......");
		try {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		LOGGER.info("Initializing City Search Index ....... Completed");
	}

	@Override
	public List<City> getAll() {
		return cityRepo.findAll();
	}

	/**
	 * A basic search for the entity User. The search is done by exact match per
	 * keywords on fields name, city and email.
	 * 
	 * @param text The query text.
	 */
	@Override
	@Transactional
	public List<City> search(String text) {

		// get the full text entity manager
		FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search
				.getFullTextEntityManager(entityManager);

		// create the query using Hibernate Search query DSL
		QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(City.class)
				.get();

		// a very basic query by keywords
		org.apache.lucene.search.Query query = queryBuilder.keyword().onFields("cityName").matching(text).createQuery();

		// wrap Lucene query in an Hibernate Query object
		org.hibernate.search.jpa.FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, City.class);

		// execute search and return results (sorted by relevance as default)
		@SuppressWarnings("unchecked")
		List<City> results = jpaQuery.getResultList();

		return results;
	} // method search

}
