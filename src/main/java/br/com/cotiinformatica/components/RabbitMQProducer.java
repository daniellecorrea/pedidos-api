package br.com.cotiinformatica.components;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cotiinformatica.events.PedidoCriado;

@Component
public class RabbitMQProducer {

	@Autowired RabbitTemplate rabbitTemplate;
	@Autowired ObjectMapper objectMapper;
	@Autowired Queue queue;
	
	/*
	 * Método para gravar um pedido criado na fila
	 */
	public void send(PedidoCriado pedidoCriado) {
		try {
			var json = objectMapper.writeValueAsString(pedidoCriado); //serializando
			rabbitTemplate.convertAndSend(queue.getName(), json); //enviando para a fila
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
