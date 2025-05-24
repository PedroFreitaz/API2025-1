package org.serratec.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.backend.dto.LancamentoVendasRequestDTO;
import org.serratec.backend.dto.LancamentoVendasResponseDTO;
import org.serratec.backend.entity.LancamentoVendas;
import org.serratec.backend.entity.Vendedor;
import org.serratec.backend.exception.LancamentoVendasException;
import org.serratec.backend.repository.LancamentoVendasRepository;
import org.serratec.backend.repository.VendedorRepository;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {
	private final LancamentoVendasRepository lancamentoVendasRepository;
	private final VendedorRepository vendedorRepository;

	public LancamentoService(LancamentoVendasRepository lancamentoVendasRepository,
			VendedorRepository vendedorRepository) {
		this.lancamentoVendasRepository = lancamentoVendasRepository;
		this.vendedorRepository = vendedorRepository;
	}

	public LancamentoVendasResponseDTO listarPorId(Long id) {
		LancamentoVendas lancamento = lancamentoVendasRepository.findById(id)
				.orElseThrow(() -> new LancamentoVendasException("Lançamento não encontrado"));
		return new LancamentoVendasResponseDTO(
				lancamento.getDataVenda(), 
				lancamento.getValorVenda(),
				lancamento.getVendedor().getNome());

	}

	public LancamentoVendas inserirLancamento(LancamentoVendasRequestDTO dto) {
		Vendedor vendedor = vendedorRepository.findById(dto.getCodigoVendedor())
				.orElseThrow(() -> new LancamentoVendasException("Vendedor não encontrado com ID: " + dto.getCodigoVendedor()));
		LancamentoVendas lancamento = new LancamentoVendas();
		lancamento.setDataVenda(dto.getDataVenda());
		lancamento.setValorVenda(dto.getValorVenda());
		lancamento.setVendedor(vendedor);
		return lancamentoVendasRepository.save(lancamento);
	}
	
	public List<LancamentoVendas> inserirVariosLancamentos(List<LancamentoVendasRequestDTO> dtos) {
	    List<LancamentoVendas> lancamentos = dtos.stream().map(dto -> {
	        Vendedor vendedor = vendedorRepository.findById(dto.getCodigoVendedor())
	            .orElseThrow(() -> new LancamentoVendasException("Vendedor com ID " + dto.getCodigoVendedor() + " não existente"));

	        LancamentoVendas lancamento = new LancamentoVendas();
	        lancamento.setDataVenda(dto.getDataVenda());
	        lancamento.setValorVenda(dto.getValorVenda());
	        lancamento.setVendedor(vendedor);

	        return lancamento;
	    }).collect(Collectors.toList());

	    return lancamentoVendasRepository.saveAll(lancamentos);
	}

}
