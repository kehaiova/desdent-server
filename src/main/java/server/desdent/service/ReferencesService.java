package server.desdent.service;

import org.springframework.stereotype.Service;
import server.desdent.model.dto.references.RequestReferencesDTO;
import server.desdent.model.pojo.References;
import server.desdent.model.repository.ReferencesRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReferencesService extends AbstractService {

    private final ReferencesRepository referencesRepository;

    public ReferencesService(ReferencesRepository referencesRepository) {
        this.referencesRepository = referencesRepository;
    }

    public List<References> getReferences(Date startDate, Date endDate, Long dentistId) {
        List<References> references = referencesRepository.findAllBySome(startDate,endDate, dentistId);
        List<RequestReferencesDTO> requestReferencesDTOS = new ArrayList<>();
        references.forEach(reference -> requestReferencesDTOS.add(modelMapper.map(reference, RequestReferencesDTO.class)));
        return  references;
    }
}
