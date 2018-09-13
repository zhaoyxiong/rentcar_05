package com.cissst.software.mapper;

import java.util.List;

import com.cissst.software.model.Company;

/**数据库访问层
 * @author Administrator
 *
 */

public interface CompanyMapper {
	/**查询公司信息
	 * @author Administrator
	 *
	 */
	public List<Company> findAll();
	
	//添加公司信息
	public void addCompany(Company company);
	
	//更改公司信息
	public void updateCompany(Company company);
	//删除公司
	public void deleteCompanyByID(String id);


}
