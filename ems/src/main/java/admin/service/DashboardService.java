package admin.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin.dao.AdminDaoImpl;

@Service
public class DashboardService {

	@Autowired
	private AdminDaoImpl adminDaoImpl;
}
