package lt.techin.from.scratch.api;

import lt.techin.from.scratch.dao.EntityRepository;
import lt.techin.from.scratch.dao.SubEntityRepository;
import lt.techin.from.scratch.entity.Entity;
import lt.techin.from.scratch.entity.SubEntity;
import lt.techin.from.scratch.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/entities")
public class EntityController {

    @Autowired
    EntityService entityService;

    //GET /api/v1
    @GetMapping("/info")
    public List<Entity> getEntities() {
        return entityService.getEntities();
    }

    @PostMapping("/info")
    public Entity createEntity(@RequestBody Entity entity) {
        return entityService.createEntity(entity);
    }

    @PostMapping("/{entityId}/subentities")
    public SubEntity createSubEntity(@RequestBody SubEntity subEntity) {
        return entityService.createSubEntity(subEntity.getId(), subEntity);
    }

    @GetMapping("/{entityId}/subentities")
    public List<SubEntity> getSubEntities(@PathVariable Long entityId) {
        return entityService.getSubEntities(entityId);
    }








}
