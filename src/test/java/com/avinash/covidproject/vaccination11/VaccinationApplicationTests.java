package com.avinash.covidproject.vaccination11;

import com.avinash.covidproject.vaccination11.dto.UserDto;
import com.avinash.covidproject.vaccination11.entity.User;
import com.avinash.covidproject.vaccination11.mapper.UserMapper;
import com.avinash.covidproject.vaccination11.repository.UserDao;
import com.avinash.covidproject.vaccination11.service.UserService;
import com.avinash.covidproject.vaccination11.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {com.avinash.covidproject.vaccination11.VaccinationApplication.class})
class VaccinationApplicationTests {

	@Test
	void contextLoads() {
	}

	private UserService userService;

	@Mock
	private UserDao mockRepository;

	@BeforeEach
	void initUseCase()
	{
		userService=new UserServiceImpl(mockRepository);
	}

	@Test
	public void findByIdMocked_WhenInvoked_ReturnsMockUser(){
		User user=new User(0,"sai","Sai","Kumar","sai@gmail.com","male",23,"765836479876","Not vaccinated");
		Mockito.when(mockRepository.findById(1)).thenReturn(user);
		Assert.assertEquals(user.getId(),UserMapper.INSTANCE.dtoToEntity(userService.findById(1)).getId());
		Mockito.verify(mockRepository).findById(1);
	}

	@Test
	public void saveUser_WhenInvoked_Success(){
		User user=new User(0,"sai","$2a$12$P3OkDevPDoA2RhkJxcuqLezLwsLO94Bnb6xetlHNYr1i2gBdlZe/q","Sai","Kumar","sai@gmail.com","male",23,"765836479876","Not vaccinated");
		Mockito.when(mockRepository.save(user)).thenReturn(user);

		UserDto userDto= UserMapper.INSTANCE.entityToDto(user);
		User theUser=userService.save(userDto);
		assertThat(theUser.getFirstName()).isNotNull();
	}

	@Test
	public void findAll_WhenMocked()
	{
		User user1=new User(0,"sai","t123","Sai","Kumar","sai@gmail.com","male",23,"765836479876","Not vaccinated");
		User user2=new User(1,"avi","a123","Avinash","Yadav","avi@gmail.com","male",24,"765846479876","Not vaccinated");
		List<User> userList=new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		Mockito.when(mockRepository.findAll()).thenReturn(userList);
		Assert.assertEquals(userList.size(),UserMapper.INSTANCE.dtosToEntities(userService.findAll()).size());
		Mockito.verify(mockRepository).findAll();
	}


}
