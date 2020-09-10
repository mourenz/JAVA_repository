package club.zqg.dao;

import club.zqg.domain.User;

import java.util.List;
import java.util.Map;

public interface MapMapper {

    List<User> getAmbiguousStudeng(Map<String, String> condition);
}
