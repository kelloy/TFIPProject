package nusiss.csf.server.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import nusiss.csf.server.model.favouriteFood;

@Repository
@Qualifier("BEAN_CACHED_MONGODB")
public interface MongoDbRepo extends MongoRepository<favouriteFood,String> {
    
    
}
