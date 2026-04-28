package com.example.MIS.and.Invoicing.System.invoice.repository;

import com.example.MIS.and.Invoicing.System.invoice.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Integer> {
    @Query("SELECT i FROM InvoiceEntity i WHERE " +
            "CAST(i.invoiceNo AS string) LIKE %:keyword% OR " +
            "CAST(i.estimation.estimatedId AS string) LIKE %:keyword% OR " +
            "CAST(i.chain.chainId AS string) LIKE %:keyword% OR " +
            "LOWER(i.chain.chainName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<InvoiceEntity> searchInvoices(@Param("keyword") String keyword);

    boolean existsByInvoiceNo(Integer invoiceNo);
}
