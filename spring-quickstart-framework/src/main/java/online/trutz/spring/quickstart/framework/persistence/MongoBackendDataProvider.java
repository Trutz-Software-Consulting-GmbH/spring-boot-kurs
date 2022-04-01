package online.trutz.spring.quickstart.framework.persistence;

import java.util.stream.Stream;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.vaadin.flow.data.provider.AbstractBackEndDataProvider;
import com.vaadin.flow.data.provider.Query;

public class MongoBackendDataProvider<T, I> extends AbstractBackEndDataProvider<T, Void> {

	private static final long serialVersionUID = -5140631230836274718L;

	private MongoRepository<T, I> mongoRepository;

	public MongoBackendDataProvider(MongoRepository<T, I> mongoRepository) {
		this.mongoRepository = mongoRepository;
	}

	@Override
	protected Stream<T> fetchFromBackEnd(Query<T, Void> query) {
		return this.mongoRepository.findAll(pageable(query)).stream();
	}

	@Override
	protected int sizeInBackEnd(Query<T, Void> query) {
		return (int) mongoRepository.count();
	}

	private Pageable pageable(Query<T, Void> query) {
		// TODO nicht nur die erste Seite zurückliefern
		query.getOffset();
		query.getPage();
		return PageRequest.ofSize(query.getPageSize());
	}

}
