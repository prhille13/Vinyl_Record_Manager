package edu.cscc.repository;

import org.springframework.data.repository.CrudRepository;
import edu.cscc.model.VinylRecord;

public interface RecordCollectionRepository extends CrudRepository<VinylRecord, Long> {

}
