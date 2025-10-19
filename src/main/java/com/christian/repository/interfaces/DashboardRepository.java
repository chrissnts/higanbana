package com.christian.repository.interfaces;

import com.christian.models.User;
import java.util.Map;

public interface DashboardRepository {
    Map<String, Object> getDashboardModel(User admin);
}
