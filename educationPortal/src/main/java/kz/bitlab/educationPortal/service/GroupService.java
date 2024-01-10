package kz.bitlab.educationPortal.service;

import java.util.List;
import kz.bitlab.educationPortal.model.Group;

public interface GroupService {
List<Group> getAllGroup();

Group findById(Long id);
}
