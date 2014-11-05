package pl.lodz.p.project.core.service.good;

import java.util.List;

import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.dto.good.GoodDTO;

/**
 *
 * @author Janiu, Milczu
 */
public interface GoodService {

    List<GoodDTO> getAll();
    
    GoodDTO getOneById(Long id);
    
    void delete(GoodDTO goodDTO);

    void save(GoodDTO goodDTO);
    
    Page<GoodDTO> search(String searchQuery, PageRequest pageRequest);

}
