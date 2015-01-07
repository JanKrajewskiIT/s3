package pl.lodz.p.project.core.service.document;

import java.util.ArrayList;
import java.util.List;

import javax.interceptor.Interceptors;

import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.dto.document.service.BaseServiceDocumentDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;

@Component
@Interceptors({TrackerInterceptor.class})
public class ServiceDocumentServiceImpl implements ServiceDocumentService {

	@Override
	public List<BaseServiceDocumentDTO> getAllBaseDocuments() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}
  
}
