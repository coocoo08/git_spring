package kr.co.together4;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component class Engine{}
@Component class Door{}
@Component
class Car{
	String color;
	int oil;
	Engine engine;
	Door[] doors;
	
	public Car() {}		//기본 생성자를 꼭 만들어줘야함

	public Car(String color, int oil, Engine engine, Door[] doors) {
		//super();
		this.color = color;
		this.oil = oil;
		this.engine = engine;
		this.doors = doors;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setOil(int oil) {
		this.oil = oil;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void setDoors(Door[] doors) {
		this.doors = doors;
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", oil=" + oil + ", engine=" + engine + ", doors=" + Arrays.toString(doors)
				+ "]";
	}
	
}

public class SpringDITest {

	public static void main(String[] args) {
		ApplicationContext ac = new GenericXmlApplicationContext("config4.xml");
		Car car = (Car)ac.getBean("car");
		Engine engine = (Engine)ac.getBean("engine");
		Door door = (Door)ac.getBean("door");
		
		car.setColor("red");
		car.setOil(300);
		car.setEngine(engine);
		car.setDoors(new Door[] {ac.getBean("door",Door.class), (Door)ac.getBean("door")});
		System.out.println("car = " + car);
	}
}
