package org.sid;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.sid.dao.PshRawRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.PshRaw;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class FileActualiteApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PshRawRepository pshRawRepository;
	public static void main(String[] args) {
		SpringApplication.run(FileActualiteApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
	//****************Test*************************//
	User user =new User("abdlaftah");
	user=userRepository.save(user);
	PshRaw pshRaw=new PshRaw(new Date(), 1	, 1, user);
	pshRawRepository.save(pshRaw);
	///************************************//////////
	List<User> users=userRepository.findAll();
	for (Iterator iterator = users.iterator(); iterator.hasNext();) {
		User user2 = (User) iterator.next();
		System.out.println(user2.getName());
	}
	
		
	}
}
