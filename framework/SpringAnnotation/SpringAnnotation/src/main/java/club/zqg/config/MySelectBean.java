package club.zqg.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MySelectBean implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub

		return new String[] {"club.zqg.pojo.Yello"}; //������Ҫע�뵽 IOC�������ȫ����
	}

}
