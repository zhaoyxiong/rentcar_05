package com.cissst.software.mapper;

import java.util.List;

import com.cissst.software.model.Company;

/**���ݿ���ʲ�
 * @author Administrator
 *
 */

public interface CompanyMapper {
	/**��ѯ��˾��Ϣ
	 * @author Administrator
	 *
	 */
	public List<Company> findAll();
	
	//��ӹ�˾��Ϣ
	public void addCompany(Company company);
	
	//���Ĺ�˾��Ϣ
	public void updateCompany(Company company);
	//ɾ����˾
	public void deleteCompanyByID(String id);


}
