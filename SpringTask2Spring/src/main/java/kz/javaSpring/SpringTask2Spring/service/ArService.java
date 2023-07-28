package kz.javaSpring.SpringTask2Spring.service;

import java.util.List;
import kz.javaSpring.SpringTask2Spring.Models.ApplicationRequest;
import org.springframework.stereotype.Service;

@Service
public interface ArService {


  List<ApplicationRequest> getAllAps();

  List<ApplicationRequest> getAllNewAr();

  List<ApplicationRequest> getAllOldAr();

  ApplicationRequest getArById(Long id);

  void creatNewAr(ApplicationRequest applicationRequest);

  void deleteArById(long id);

  void setArHandled(Long id);
}
