package br.com.fiap.eduardo.programa;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import br.com.fiap.eduardo.dao.GenericDao;
import br.com.fiap.eduardo.entity.Cliente;
import br.com.fiap.eduardo.entity.Pedido;

public class Main {

	private final static GenericDao<Cliente> CLIENTE_DAO = new GenericDao<>(Cliente.class);
	private final static GenericDao<Pedido> PEDIDO_DAO = new GenericDao<>(Pedido.class);

	public static void main(String[] args) {

		try {
			Cliente clienteEduardo = new Cliente("Eduardo Soares", "eduardosoares@email.com");
			Cliente clienteMilena = new Cliente("Milena Aberton", "milena@email.com");

			CLIENTE_DAO.adicionar(clienteEduardo);
			CLIENTE_DAO.adicionar(clienteMilena);

			Cliente clienteEduardoSalvo = CLIENTE_DAO.buscar(clienteEduardo.getIdCliente());
			Cliente clienteMilenaSalvo = CLIENTE_DAO.buscar(clienteMilena.getIdCliente());

			System.out.println(clienteEduardo);
			System.out.println(clienteMilena);

			clienteEduardoSalvo.setNome("Eduardo Soares dos Santos");
			clienteMilenaSalvo.setEmail("milena@email.com");

			CLIENTE_DAO.atualizar(clienteEduardoSalvo);
			CLIENTE_DAO.atualizar(clienteMilenaSalvo);

			clienteEduardoSalvo = CLIENTE_DAO.buscar(clienteEduardo.getIdCliente());
			clienteMilenaSalvo = CLIENTE_DAO.buscar(clienteMilena.getIdCliente());

			System.out.println(clienteEduardoSalvo);
			System.out.println(clienteMilenaSalvo);

			// Pedidos Eduardo
			Pedido pedidoEduardo1 = new Pedido(clienteEduardoSalvo, LocalDateTime.of(2017, Month.NOVEMBER, 23, 12, 0),
					"Pneu Firestone", 236.0);
			Pedido pedidoEduardo2 = new Pedido(clienteEduardoSalvo, LocalDateTime.of(2017, Month.MARCH, 01, 9, 25),
					"Calota Fusca", 154.78);
			Pedido pedidoEduardo3 = new Pedido(clienteEduardoSalvo, LocalDateTime.of(2017, Month.AUGUST, 17, 11, 14),
					"Escapamento Civic", 587.77);
			Pedido pedidoEduardo4 = new Pedido(clienteEduardoSalvo,
					LocalDateTime.of(2017, Month.SEPTEMBER, 30, 18, 30), "Lapis", 0.85);

			PEDIDO_DAO.adicionar(pedidoEduardo1);
			PEDIDO_DAO.adicionar(pedidoEduardo2);
			PEDIDO_DAO.adicionar(pedidoEduardo3);
			PEDIDO_DAO.adicionar(pedidoEduardo4);

			// Pedidos Milena
			Pedido pedidoMilena1 = new Pedido(clienteMilenaSalvo, LocalDateTime.of(2017, Month.NOVEMBER, 23, 12, 0),
					"Vidro Dianteiro", 417.74);
			Pedido pedidoMilena2 = new Pedido(clienteMilenaSalvo, LocalDateTime.of(2017, Month.MARCH, 01, 9, 25),
					"Farol Traseiro", 36.74);
			Pedido pedidoMilena3 = new Pedido(clienteMilenaSalvo, LocalDateTime.of(2017, Month.AUGUST, 17, 11, 14),
					"Limpador para Brisa", 99.74);

			PEDIDO_DAO.adicionar(pedidoMilena1);
			PEDIDO_DAO.adicionar(pedidoMilena2);
			PEDIDO_DAO.adicionar(pedidoMilena3);

			Pedido pedido = PEDIDO_DAO.buscar(pedidoEduardo1.getIdPedido());
			System.out.println(pedido);

			List<Pedido> pedidos = PEDIDO_DAO.listar();
			pedidos.forEach(System.out::println);
			pedidos.forEach(PEDIDO_DAO::remover);

			List<Cliente> clientes = CLIENTE_DAO.listar();
			clientes.forEach(System.out::println);
			clientes.forEach(CLIENTE_DAO::remover);

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}

}