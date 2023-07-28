package kz.javaSpring.SpringTask2Spring.service.impl;

import java.util.Comparator;
import java.util.List;
import kz.javaSpring.SpringTask2Spring.Models.ApplicationRequest;
import kz.javaSpring.SpringTask2Spring.repositories.ArRepository;
import kz.javaSpring.SpringTask2Spring.service.ArService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArServiceImpl implements ArService {

  @Autowired
  private ArRepository arRepository;

  @Override
  public List<ApplicationRequest> getAllAps() {
    return arRepository.findAll();
  }

  @Override
  public List<ApplicationRequest> getAllNewAr() {
    List<ApplicationRequest> appReqList = arRepository.findAll();
    return appReqList.stream().filter(appReq -> !appReq.isHandled())
        .toList();
  }

  @Override
  public List<ApplicationRequest> getAllOldAr() {
    List<ApplicationRequest> appReqList = arRepository.findAll();
    return appReqList.stream().filter(appReq -> appReq.isHandled())
        .toList();
  }

  @Override
  public ApplicationRequest getArById(Long id) {
    return arRepository.findById(id).orElse(null);
  }

  @Override
  public void creatNewAr(ApplicationRequest applicationRequest) {
    applicationRequest.setHandled(false);
    arRepository.save(applicationRequest);
  }

  @Override
  public void deleteArById(long id) {
    arRepository.deleteById(id);
  }

  @Override
  public void setArHandled(Long id) {
    ApplicationRequest applicationRequest = arRepository.findById(id).orElse(null);
    assert applicationRequest != null;
    applicationRequest.setHandled(true);
    arRepository.save(applicationRequest);
  }
}
