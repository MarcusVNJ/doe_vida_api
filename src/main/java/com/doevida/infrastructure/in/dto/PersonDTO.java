package com.doevida.infrastructure.in.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record PersonDTO(
        @NotBlank(message = "O name não pode ser nulo ou vazio")
        @JsonProperty("nome")
        String name,

        @NotBlank(message = "O CPF não pode ser nulo ou vazio")
        String cpf,

        @NotBlank(message = "O RG não pode ser nulo ou vazio")
        String rg,

        @NotBlank(message = "A data de nascimento não pode ser nula ou vazia")
        @JsonFormat(pattern = "dd/MM/yyyy")
        @JsonProperty("data_nasc")
        String dateBirth,

        @JsonProperty("sexo")
        @NotBlank(message = "O sexo não pode ser nulo ou vazio")
        String gender,

        @JsonProperty("mae")
        @NotBlank(message = "O name da mãe não pode ser nulo ou vazio")
        String mother,

        @JsonProperty("pai")
        @NotBlank(message = "O name do father não pode ser nulo ou vazio")
        String father,

        @Email(message = "O email deve ser válido")
        @NotBlank(message = "O email não pode ser nulo ou vazio")
        String email,

        @JsonProperty("cep")
        @NotBlank(message = "O CEP não pode ser nulo ou vazio")
        String zipCode,

        @JsonProperty("endereco")
        @NotBlank(message = "O endereço não pode ser nulo ou vazio")
        String address,

        @JsonProperty("numero")
        @Min(value = 1, message = "O número deve ser maior que zero")
        Integer number,

        @JsonProperty("bairro")
        @NotBlank(message = "O bairro não pode ser nulo ou vazio")
        String neighborhood,

        @JsonProperty("cidade")
        @NotBlank(message = "A cidade não pode ser nula ou vazia")
        String city,

        @JsonProperty("estado")
        @NotBlank(message = "O estado não pode ser nulo ou vazio")
        String state,

        @NotBlank(message = "O phone fixo não pode ser nulo ou vazio")
        @JsonProperty("telefone_fixo")
        String phone,

        @JsonProperty("celular")
        @NotBlank(message = "O mobilePhone não pode ser nulo ou vazio")
        String mobilePhone,

        @JsonProperty("altura")
        @Min(value = 0, message = "A height deve ser maior ou igual a zero")
        @Max(value = 3, message = "A height deve ser menor ou igual a 3 metros")
        Float height,

        @JsonProperty("peso")
        @Min(value = 1, message = "O weight deve ser maior que zero")
        Float weight,

        @NotBlank(message = "O type sanguíneo não pode ser nulo ou vazio")
        @JsonProperty("tipo_sanguineo")
        String bloodType
) {
}
