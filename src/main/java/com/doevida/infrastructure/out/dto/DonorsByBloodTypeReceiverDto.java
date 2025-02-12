package com.doevida.infrastructure.out.dto;

public interface DonorsByBloodTypeReceiverDto extends DtoResponse {

    String getTipoSanguineoReceptor();
    Integer getQuantidadeDoadores();

}
