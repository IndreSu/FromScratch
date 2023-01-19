package lt.techin.from.scratch.dao;


import lt.techin.from.scratch.entity.Entity;
import lt.techin.from.scratch.entity.SubEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubEntityRepository extends JpaRepository<SubEntity, Long> {

    List<SubEntity> findAllByEntity(Entity entity);


}
