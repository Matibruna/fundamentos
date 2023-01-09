package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;

	private MyBeanWithProperties myBeanWithProperties;

	private UserPojo userPojo;

	private UserRepository userRepository;

	@Autowired
	public FundamentosApplication(
			@Qualifier("componentImplement") ComponentDependency componentDependency,
			MyBean myBean,
			MyBeanWithDependency myBeanWithDependency,
			MyBeanWithProperties myBeanWithProperties,
			UserPojo userPojo,
			UserRepository userRepository
			){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		clasesAnteriores();
		//saveUsersInDataBase();
	}

	private void saveUsersInDataBase(){
		User user1 = new User( "John", "john@gmail.com", LocalDate.of(2021, 03, 20) );
		User user2 = new User( "Mateo", "mateo@gmail.com", LocalDate.of(2019, 11, 31) );
		User user3 = new User( "user3", "user3@gmail.com", LocalDate.of(2021, 05, 3) );
		User user4 = new User( "user4", "user4@gmail.com", LocalDate.of(2021, 04, 11) );
		User user5 = new User( "user5", "user5@gmail.com", LocalDate.of(2021, 07, 4) );
		User user6 = new User( "user6", "user6@gmail.com", LocalDate.of(2021, 9, 23) );
		User user7 = new User( "user7", "user7@gmail.com", LocalDate.of(2021, 10, 7) );
		User user8 = new User( "user8", "user8@gmail.com", LocalDate.of(2021, 04, 5) );
		User user9 = new User( "user9", "user9@gmail.com", LocalDate.of(2021, 02, 22) );
		User user10 = new User( "user10", "user10@gmail.com", LocalDate.of(2021, 8, 18) );

		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);

		list.stream().forEach(userRepository::save);
	}

	private void clasesAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency(5);
		System.out.println(myBeanWithProperties.print());
		System.out.println(userPojo.getAge());
		LOGGER.error("Ha ocurrido un error en la aplicacion");
	}
}
