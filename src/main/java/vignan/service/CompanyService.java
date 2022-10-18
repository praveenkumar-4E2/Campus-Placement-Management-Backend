package vignan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vignan.model.Company;
import vignan.repository.CompanyRepository;

@Service
public class CompanyService {
	@Autowired
	CompanyRepository companyRepository;
	
	public Company addCompany(Company company) {
		return companyRepository.save(company);
	}
	
	
	public List<Company> getall() {
		return companyRepository.findAll();
	}
	public String deleteCompany(int id) {
		companyRepository.deleteById(id);
		return "deleted";
	}
	
}
