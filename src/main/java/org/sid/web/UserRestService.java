package org.sid.web;


import java.util.Date;
import java.util.List;
import org.sid.dao.PshRawRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.PshRaw;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class UserRestService {
 
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PshRawRepository pshRawRepository;
	
	//Method for update Attendance
	@RequestMapping(value="/attendance" ,method=RequestMethod.PUT)
	public void attendance(@RequestParam(name="id") Long id,@RequestParam(name="val") int val){
		User user=userRepository.getOne(id);
		//'Enter = 1; Leave = 0
		PshRaw pshRaw=new PshRaw();
		pshRaw.setDirect(val);
		Date d=new Date();
		pshRaw.setTime(d);
		pshRawRepository.save(pshRaw);
	}
	
	//Method for list All user
	@RequestMapping("/listeUsers")
	public List<org.sid.entities.User> listeUser(){
		
		return userRepository.findAll();
	}
	
	//All attendance for one user
	@RequestMapping(value="/chercher",method=RequestMethod.GET)
	public Page<PshRaw> search(@RequestParam(name="name",defaultValue="") String name,@RequestParam(name="page",defaultValue="0") int page,@RequestParam(name="size",defaultValue="4") int size){
	return pshRawRepository.findByUser(name, new PageRequest(page, size));
		
	}
	
	//search info for user by name
	@RequestMapping(value="/searchUsers",method=RequestMethod.GET)
	public Page<User> searchUser(@RequestParam(name="name",defaultValue="") String name,@RequestParam(name="page",defaultValue="0") int page,@RequestParam(name="size",defaultValue="4") int size){
		return userRepository.rechercher("%"+name+"%", new PageRequest(page, size));
	}

}
