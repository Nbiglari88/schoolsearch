package app;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SchoolRepository extends PagingAndSortingRepository<School, String> {
    public School findByCity(String City);
    public List<School> findByName(String Name);
}
