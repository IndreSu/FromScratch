package lt.techin.from.scratch.service;

import lt.techin.from.scratch.dao.EntityRepository;
import lt.techin.from.scratch.dao.SubEntityRepository;
import lt.techin.from.scratch.entity.Entity;
import lt.techin.from.scratch.entity.SubEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class EntityService {

    private EntityRepository entityRepository;
    private SubEntityRepository subEntityRepository;

    @Autowired
    public EntityService(EntityRepository entityRepository, SubEntityRepository subEntityRepository) {
        this.entityRepository = entityRepository;
        this.subEntityRepository = subEntityRepository;
    }

    @GetMapping
    public List<Entity> getEntities() {
        return entityRepository.findAll();
    }

    @PostMapping
    public Entity createEntity(@RequestBody Entity entity) {
        return entityRepository.save(entity);
    }

    @PostMapping
    public SubEntity createSubEntity(@PathVariable Long entityId, @RequestBody SubEntity subEntity) {
        var entity = entityRepository.findById(entityId)
                .orElseThrow(() -> new NullPointerException(String.format("Entity with id is not found", entityId)));

        subEntity.setEntity(entity);
        return subEntityRepository.save(subEntity);
    }

    @GetMapping
    public List<SubEntity> getSubEntities(@PathVariable Long entityId) {
        var entity = entityRepository.findById(entityId)
                .orElseThrow(() -> new NullPointerException(String.format("Entity with id is not found", entityId)));

        return subEntityRepository.findAllByEntity(entity);
    }


}
