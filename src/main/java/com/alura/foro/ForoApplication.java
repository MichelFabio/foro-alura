package com.alura.foro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/prueba")
public class ForoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForoApplication.class, args);
	}

	@GetMapping
	public List<Integer> prueba(){
		int [] arr = {1,2,3,4,5,6,7,8,9,0};
		List<Integer> lista = new ArrayList<>();
		for (int a : arr){
			lista.add(a);
		}
		return lista;
	}

}
