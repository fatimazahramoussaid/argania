package cloudcode.guestbook.backend;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * represents a custom Mongo repository that stores FeatureEntry objects
 */
public interface MessageRepository extends
    MongoRepository<FeatureEntry, String> { }
