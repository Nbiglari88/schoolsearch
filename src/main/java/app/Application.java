package app;

import app.rabbitMQ.Receiver;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Application implements CommandLineRunner {

	@Autowired
	private SchoolRepository repository;

	private char[] password = "hello123".toCharArray();

	@Autowired
	final public static String queueName = "spring-boot";

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange("spring-boot-exchange");
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(queueName);
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
											 MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

	@RequestMapping("/")
	public String home() {
		return "Hello Docker World";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String[] args) throws Exception {

		repository.deleteAll();

		repository.save(new School("Utrecht", "Dalton School"));
		repository.save(new School("Rotterdam", "Montessori School"));
		repository.save(new School("Den Haag", "Katholieke School"));

		System.out.println("Schools found with findAll(): ");
		System.out.println("-------------------------------");
		for (School school : repository.findAll()) {
			System.out.println(school);
		}
		System.out.println();

		System.out.println("School found with findByCity('Utrecht'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByCity("Utrecht"));

		System.out.println("Customers found with findName('Montessori School'):");
		System.out.println("--------------------------------");
		for (School school : repository.findByName("Montessori School")) {
			System.out.println(school);

		}

	}
}