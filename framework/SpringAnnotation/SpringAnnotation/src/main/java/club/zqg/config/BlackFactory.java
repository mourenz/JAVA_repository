package club.zqg.config;

import org.springframework.beans.factory.FactoryBean;

import club.zqg.pojo.Black;

public class BlackFactory implements FactoryBean<Black> {

	@Override
	public Black getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Black();
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Black.class;
	}
	
	
	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;// µ×²ã·µ»ØµÄÊÇ true
	}

}
