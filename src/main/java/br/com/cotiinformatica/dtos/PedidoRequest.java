package br.com.cotiinformatica.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PedidoRequest {

	@NotNull(message = "Por favor, informe o valor do pedido.")
	@DecimalMin(value = "0.01", message = "Por favor, informe um valor mínimo de '0.01'.")
	private Double valor;
		
	@NotBlank(message = "Por favor, informe o cliente do pedido.")
	@Size(min = 8, max = 100, message = "Por favor, informe de 8 a 100 caracteres.")
	private String cliente;
	
	@NotBlank(message = "Por favor, informe os detalhes do pedido.")
	@Size(min = 8, max = 250, message = "Por favor, informe de 8 a 250 caracteres.")
	private String detalhes;
}
