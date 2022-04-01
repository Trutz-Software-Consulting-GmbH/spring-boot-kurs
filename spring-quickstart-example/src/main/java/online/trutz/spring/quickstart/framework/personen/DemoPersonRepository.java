package online.trutz.spring.quickstart.framework.personen;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoPersonRepository extends MongoRepository<DemoPerson, ObjectId> {
}
