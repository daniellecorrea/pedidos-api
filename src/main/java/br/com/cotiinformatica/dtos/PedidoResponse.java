package br.com.cotiinformatica.dtos;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class PedidoResponse {

	private UUID id;
	private Date dataPedido;
	private Double valor;
	private String cliente;
	private String detalhes;
	private String status;
}
