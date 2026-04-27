package com.example.MIS.and.Invoicing.System.chainmanagement.service;

import com.example.MIS.and.Invoicing.System.chainmanagement.dto.ChainDTO;
import com.example.MIS.and.Invoicing.System.chainmanagement.entity.ChainEntity;
import com.example.MIS.and.Invoicing.System.groupmanagement.entity.CustomerGroupEntity;
import com.example.MIS.and.Invoicing.System.chainmanagement.repository.ChainRepository;
import com.example.MIS.and.Invoicing.System.groupmanagement.repository.CustomerGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChainService {

    private final ChainRepository chainRepository;
    private final CustomerGroupRepository customerGroupRepository;

    public ChainService(ChainRepository chainRepository, CustomerGroupRepository customerGroupRepository) {
        this.chainRepository = chainRepository;
        this.customerGroupRepository = customerGroupRepository;
    }

    public ChainEntity addChain(ChainDTO chainDTO) {
        if (chainRepository.existsByChainNameAndIsActiveTrue(chainDTO.getChainName())) {
            throw new RuntimeException("Chain name already exists");
        }
        CustomerGroupEntity group = customerGroupRepository.findById(chainDTO.getGroupId())
                .orElseThrow(() -> new RuntimeException("Group not found"));
        ChainEntity chain = new ChainEntity();
        chain.setChainName(chainDTO.getChainName());
        chain.setGroup(group);
        chain.setActive(true);
        return chainRepository.save(chain);
    }

    public List<ChainEntity> getAllChains() {
        return chainRepository.findAllByIsActiveTrue();
    }

    public ChainEntity updateChain(Long id, ChainDTO chainDTO) {
        ChainEntity chain = chainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chain not found"));
        if (chainRepository.existsByChainNameAndIsActiveTrue(chainDTO.getChainName())) {
            throw new RuntimeException("Chain name already taken");
        }
        chain.setChainName(chainDTO.getChainName());
        return chainRepository.save(chain);
    }

    public String deleteChain(Long id) {
        ChainEntity chain = chainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chain not found"));
        chain.setActive(false);
        chainRepository.save(chain);
        return "Chain deleted successfully";
    }
}
