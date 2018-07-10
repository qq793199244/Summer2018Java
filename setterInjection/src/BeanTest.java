import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangyue.service.Person;

public class BeanTest {

	public static void main(String[] args) {
		
		//1.����spring����
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		//2.��ȡidΪchinese��beanʵ��
		Person p = (Person) ac.getBean("chinese");
		//3.����useAxe()����
		p.useAxe();

	}

}
